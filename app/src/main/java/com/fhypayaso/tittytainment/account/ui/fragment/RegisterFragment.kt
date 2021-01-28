package com.fhypayaso.tittytainment.account.ui.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.fhypayaso.tittytainment.MainActivity
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.account.ui.helper.AccountCheckHelper
import com.fhypayaso.tittytainment.account.viewmodel.AccountViewModel
import com.fhypayaso.tittytainment.base.BaseFragment
import com.fhypayaso.tittytainment.databinding.FragmentAccountBinding
import com.fhypayaso.utils.ToastUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 11:01 AM
#   @Description   : 
# ====================================================*/
@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentAccountBinding>(R.layout.fragment_account) {

    @Inject
    lateinit var mCheckHelper: AccountCheckHelper

    private val viewModel: AccountViewModel by viewModels()

    override fun viewBinding(view: View): FragmentAccountBinding {
        return FragmentAccountBinding.bind(view)
    }

    override fun initView() {

        binding.btnLoginModel.visibility = View.GONE
        binding.layoutSms.visibility = View.VISIBLE
        binding.layoutPassword.visibility = View.VISIBLE

        binding.btnGoRegister.text = getString(R.string.account_go_login)
        binding.btnGoRegister.setOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }

        binding.btnSubmit.text = getString(R.string.account_register)
        binding.btnSubmit.setOnClickListener { register() }

        binding.btnSms.setOnClickListener { sendSmsCode() }
    }


    override fun initViewModel() {
        viewModel.registerStatusLiveData.observe(this, Observer {
            MainActivity.startActivity(context)
            activity?.finish()
        })
        viewModel.smsStatusLiveData.observe(this, Observer {
            ToastUtil.showToast(context, R.string.toast_sms_has_send)
        })
        viewModel.smsClickableLiveData.observe(this, Observer {
            binding.btnSms.isClickable = it
            binding.btnSms.text = getString(
                if (it) R.string.account_sms else R.string.account_has_send
            )
        })
    }

    private fun sendSmsCode() {
        binding.editPhone.also {
            if (mCheckHelper.checkPhone(it)) {
                viewModel.sendSmsCode(it.text.toString())
            }
        }
    }


    private fun register() {

        if (mCheckHelper.checkRegister(binding.editPhone, binding.editSms, binding.editPassword)
        ) {
            val phone = binding.editPhone.text.toString()
            val password = binding.editPassword.text.toString()
            val smsCode = binding.editSms.text.toString()
            viewModel.register(phone, password, smsCode)
        }
    }


}
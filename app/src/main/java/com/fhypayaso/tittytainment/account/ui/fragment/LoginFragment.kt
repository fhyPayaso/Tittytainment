package com.fhypayaso.tittytainment.account.ui.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.fhypayaso.tittytainment.MainActivity
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.account.ui.helper.AccountCheckHelper
import com.fhypayaso.tittytainment.account.ui.helper.LoginModel
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
#   @Date          : 1/27/21 11:07 AM
#   @Description   : 
# ====================================================*/
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentAccountBinding>(R.layout.fragment_account) {

    @Inject
    lateinit var mCheckHelper: AccountCheckHelper

    private val viewModel: AccountViewModel by viewModels()

    private var mLoginModel: LoginModel = LoginModel.PASSWORD

    override fun viewBinding(view: View): FragmentAccountBinding {
        return FragmentAccountBinding.bind(view)
    }


    override fun initView() {
        refreshLoginModel()
        binding.btnSubmit.setOnClickListener { login() }
        binding.btnSms.setOnClickListener { sendSmsCode() }
        binding.btnLoginModel.setOnClickListener {
            mLoginModel =
                if (mLoginModel == LoginModel.PASSWORD) LoginModel.SMS else LoginModel.PASSWORD
            refreshLoginModel()
        }
        binding.btnGoRegister.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_go_register)
        }
    }


    override fun initViewModel() {
        viewModel.loginStatusLiveData.observe(this, Observer {
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

    private fun refreshLoginModel() {

        if (mLoginModel == LoginModel.PASSWORD) {
            binding.layoutPassword.visibility = View.VISIBLE
            binding.layoutSms.visibility = View.GONE
            binding.btnLoginModel.text = getString(R.string.account_go_sms)

        } else if (mLoginModel == LoginModel.SMS) {
            binding.layoutPassword.visibility = View.GONE
            binding.layoutSms.visibility = View.VISIBLE
            binding.btnLoginModel.text = getString(R.string.account_go_password)
        }
    }


    private fun login() {


        if (!mCheckHelper.checkPhone(binding.editPhone)) {
            return
        }

        val phone = binding.editPhone.text.toString()
        if (mLoginModel == LoginModel.PASSWORD) {
            binding.editPassword.also {
                if (mCheckHelper.checkPassword(it)) {
                    viewModel.loginByPassword(phone, it.text.toString())
                }
            }
        } else if (mLoginModel == LoginModel.SMS) {
            binding.editSms.also {
                if (mCheckHelper.checkSmsCode(it)) {
                    viewModel.loginBySmsCode(phone, it.text.toString())
                }
            }
        }
    }
}
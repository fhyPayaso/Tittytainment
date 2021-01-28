package com.fhypayaso.tittytainment.account.ui.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.account.viewmodel.AccountViewModel
import com.fhypayaso.utils.ToastUtil
import dagger.hilt.android.AndroidEntryPoint

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 11:01 AM
#   @Description   : 
# ====================================================*/
@AndroidEntryPoint
class RegisterFragment : AccountFragment() {

    private val viewModel: AccountViewModel by viewModels()

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


        viewModel.registerStatusLiveData.observe(this, Observer { goMainActivity() })
        viewModel.smsStatusLiveData.observe(this, Observer {
            ToastUtil.showToast(context, "验证码已发送，请注意查收")
        })
        viewModel.smsClickableLiveData.observe(this, Observer {
            binding.btnSms.isClickable = it
            binding.btnSms.text = getString(
                if (it) R.string.account_sms else R.string.account_has_send
            )
        })
    }

    private fun sendSmsCode() {

        val phone = binding.editPhone.text
        if (phone.isNullOrEmpty()) {
            binding.editPhone.error = getString(R.string.error_empty_phone)
            return
        }
        viewModel.sendSmsCode(phone.toString())
    }


    private fun register() {

        if (!checkParam()) {
            return
        }

        val phone = binding.editPhone.text.toString()
        val password = binding.editPassword.text.toString()
        val smsCode = binding.editSms.text.toString()
        viewModel.register(phone, password, smsCode)
    }
}
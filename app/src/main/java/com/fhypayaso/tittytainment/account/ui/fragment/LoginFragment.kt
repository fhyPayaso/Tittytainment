package com.fhypayaso.tittytainment.account.ui.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.fhypayaso.tittytainment.MainActivity
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.account.ui.LoginModel
import com.fhypayaso.tittytainment.account.viewmodel.AccountViewModel
import com.fhypayaso.utils.ToastUtil
import dagger.hilt.android.AndroidEntryPoint

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 11:07 AM
#   @Description   : 
# ====================================================*/
@AndroidEntryPoint
class LoginFragment : AccountFragment() {


    private val viewModel: AccountViewModel by viewModels()


    private var mLoginModel: LoginModel = LoginModel.PASSWORD


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
        viewModel.loginStatusLiveData.observe(this, Observer { goMainActivity() })
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

        val phone = binding.editPhone.text
        if (phone.isNullOrEmpty()) {
            binding.editPhone.error = getString(R.string.error_empty_phone)
            return
        }
        viewModel.sendSmsCode(phone.toString())

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

        if (!checkParam()) {
            return
        }

        val phone = binding.editPhone.text.toString()
        if (mLoginModel == LoginModel.PASSWORD) {
            val password = binding.editPassword.text.toString()
            viewModel.loginByPassword(phone, password)

        } else if (mLoginModel == LoginModel.SMS) {
            val smsCode = binding.editSms.text.toString()
            viewModel.loginBySmsCode(phone, smsCode)
        }
    }
}
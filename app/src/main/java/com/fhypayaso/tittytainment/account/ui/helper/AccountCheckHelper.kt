package com.fhypayaso.tittytainment.account.ui.helper

import com.fhypayaso.tittytainment.App
import com.fhypayaso.tittytainment.R
import com.google.android.material.textfield.TextInputEditText

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/28/21 9:55 PM
#   @Description   : 
# ====================================================*/
class AccountCheckHelper {


    fun checkRegister(
        phone: TextInputEditText,
        smsCode: TextInputEditText,
        password: TextInputEditText
    ): Boolean {
        return checkPhone(phone) && checkPassword(password) && checkSmsCode(smsCode)
    }


    fun checkPhone(editText: TextInputEditText): Boolean {
        val phone = editText.text
        if (phone.isNullOrBlank()) {
            editText.error = App.instance().getString(R.string.error_empty_phone)
            return false
        }
        return true
    }


    fun checkSmsCode(editText: TextInputEditText): Boolean {

        val sms = editText.text
        if (sms.isNullOrBlank()) {
            editText.error = App.instance().getString(R.string.error_empty_sms)
            return false
        }
        return true
    }

    fun checkPassword(editText: TextInputEditText): Boolean {

        val sms = editText.text
        if (sms.isNullOrBlank()) {
            editText.error = App.instance().getString(R.string.error_empty_password)
            return false
        }
        return true
    }


}
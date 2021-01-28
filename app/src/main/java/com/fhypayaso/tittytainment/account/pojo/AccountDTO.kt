package com.fhypayaso.tittytainment.account.pojo

import com.google.gson.annotations.SerializedName

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 9:10 PM
#   @Description   : 
# ====================================================*/


data class RegisterRequest(
    @SerializedName("phone_number") val phone: String,
    @SerializedName("captcha") val smsCode: String,
    @SerializedName("password") val password: String
)


data class LoginPswRequest(
    @SerializedName("phone_number") val phone: String,
    @SerializedName("password") val password: String
)

data class LoginSmsRequest(
    @SerializedName("phone_number") val phone: String,
    @SerializedName("captcha") val smsCode: String
)
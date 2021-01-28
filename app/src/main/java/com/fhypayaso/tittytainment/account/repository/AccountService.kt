package com.fhypayaso.tittytainment.account.repository

import com.fhypayaso.network.bean.ApiResponse
import com.fhypayaso.tittytainment.account.pojo.LoginPswRequest
import com.fhypayaso.tittytainment.account.pojo.LoginSmsRequest
import com.fhypayaso.tittytainment.account.pojo.RegisterRequest
import com.fhypayaso.tittytainment.profile.pojo.User
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.Response
import retrofit2.http.*

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 7:29 PM
#   @Description   : 
# ====================================================*/
interface AccountService {


    @GET("sms/captcha/{phone_number}")
    fun sendSmsCode(@Path("phone_number") phone: String): Observable<Response<ApiResponse<Int>>>

    @POST("user/login")
    fun loginByPassword(@Body param: LoginPswRequest): Observable<Response<ApiResponse<Int>>>

    @POST("user/login/sms")
    fun loginBySmsCode(@Body param: LoginSmsRequest): Observable<Response<ApiResponse<Int>>>

    @POST("user/register")
    fun register(@Body param: RegisterRequest): Observable<Response<ApiResponse<Int>>>

    @GET("user/info/token")
    fun fetchUserInfo(): Observable<Response<ApiResponse<User>>>
}
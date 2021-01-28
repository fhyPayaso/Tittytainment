package com.fhypayaso.tittytainment.account.repository

import com.fhypayaso.network.rxcallback.MapperFunction
import com.fhypayaso.network.rxcallback.VoidMapperFunction
import com.fhypayaso.tittytainment.account.pojo.LoginPswRequest
import com.fhypayaso.tittytainment.account.pojo.LoginSmsRequest
import com.fhypayaso.tittytainment.account.pojo.RegisterRequest
import com.fhypayaso.tittytainment.base.repository.BaseFetcher
import com.fhypayaso.tittytainment.profile.pojo.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 7:28 PM
#   @Description   : 
# ====================================================*/
class AccountFetcher constructor(
    private val api: AccountService
) : BaseFetcher {


    fun sendSmsCode(phone: String): Observable<Int> {
        return api.sendSmsCode(phone)
            .map(VoidMapperFunction())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun loginByPassword(param: LoginPswRequest): Observable<Int> {

        return api.loginByPassword(param)
            .map(VoidMapperFunction())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun loginBySmsCode(param: LoginSmsRequest): Observable<Int> {
        return api.loginBySmsCode(param)
            .map(VoidMapperFunction())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun register(param: RegisterRequest): Observable<Int> {
        return api.register(param)
            .map(VoidMapperFunction())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun checkToken(): Observable<User> {
        return api.fetchUserInfo()
            .map(MapperFunction<User>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}
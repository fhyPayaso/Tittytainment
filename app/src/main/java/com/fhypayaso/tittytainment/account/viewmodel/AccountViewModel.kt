package com.fhypayaso.tittytainment.account.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.fhypayaso.network.rxcallback.ToastExceptionConsumer
import com.fhypayaso.tittytainment.account.pojo.LoginPswRequest
import com.fhypayaso.tittytainment.account.pojo.LoginSmsRequest
import com.fhypayaso.tittytainment.account.pojo.RegisterRequest
import com.fhypayaso.tittytainment.account.repository.AccountRepository
import com.fhypayaso.tittytainment.base.viewmodel.BaseViewModel
import io.reactivex.functions.Consumer
import kotlinx.coroutines.*

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 7:08 PM
#   @Description   : 
# ====================================================*/
class AccountViewModel @ViewModelInject constructor(
    private val repository: AccountRepository
) : BaseViewModel() {


    companion object {

        const val SMS_DURATION: Long = 1000 * 10

    }


    val loginStatusLiveData: MutableLiveData<Int> = MutableLiveData()

    val registerStatusLiveData: MutableLiveData<Int> = MutableLiveData()

    val smsStatusLiveData: MutableLiveData<Int> = MutableLiveData()

    val smsClickableLiveData: MutableLiveData<Boolean> = MutableLiveData()


    fun loginByPassword(phone: String, password: String) {
        register(
            repository.fetcher()
                .loginByPassword(LoginPswRequest(phone, password))
                .subscribe(Consumer {
                    loginStatusLiveData.postValue(it)
                }, ToastExceptionConsumer())
        )
    }


    fun loginBySmsCode(phone: String, smsCode: String) {
        register(
            repository.fetcher()
                .loginBySmsCode(LoginSmsRequest(phone, smsCode))
                .subscribe(Consumer {
                    loginStatusLiveData.postValue(it)
                }, ToastExceptionConsumer())
        )

    }

    fun sendSmsCode(phone: String) {
        register(
            repository.fetcher()
                .sendSmsCode(phone)
                .subscribe(Consumer {
                    smsStatusLiveData.postValue(it)
                    smsClickableLiveData.postValue(false)
                    // 开启协程
                    GlobalScope.launch(Dispatchers.Unconfined) {
                        delay(SMS_DURATION)
                        smsClickableLiveData.postValue(true)
                    }
                }, ToastExceptionConsumer())

        )
    }


    fun register(phone: String, password: String, smsCode: String) {
        register(
            repository.fetcher()
                .register(RegisterRequest(phone, smsCode, password))
                .subscribe(Consumer {
                    registerStatusLiveData.postValue(it)
                }, ToastExceptionConsumer())
        )
    }


}
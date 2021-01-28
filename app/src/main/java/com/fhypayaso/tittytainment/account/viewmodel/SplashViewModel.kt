package com.fhypayaso.tittytainment.account.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.fhypayaso.tittytainment.account.repository.AccountRepository
import com.fhypayaso.tittytainment.base.viewmodel.BaseViewModel
import io.reactivex.functions.Consumer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/28/21 8:44 PM
#   @Description   : 
# ====================================================*/
class SplashViewModel @ViewModelInject constructor(
    private val repository: AccountRepository
) : BaseViewModel() {

    companion object {
        const val SPLASH_DURATION: Long = 1000 * 2
    }

    val tokenStatusLiveData: MutableLiveData<Boolean> = MutableLiveData()


    fun onSplashShow() {
        GlobalScope.launch(Dispatchers.Unconfined) {
            delay(SPLASH_DURATION)
            register(
                repository.fetcher().checkToken()
                    .subscribe({ tokenStatusLiveData.postValue(true) },
                        { tokenStatusLiveData.postValue(false) })
            )
        }
    }

}
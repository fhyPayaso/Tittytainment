package com.fhypayaso.tittytainment.base.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 7:23 PM
#   @Description   : 
# ====================================================*/
abstract class BaseViewModel : ViewModel() {

    private val mDisposable = CompositeDisposable()


    override fun onCleared() {
        mDisposable.dispose()
        mDisposable.clear()
        super.onCleared()
    }


    protected fun register(disposable: Disposable) {
        mDisposable.add(disposable)
    }

}
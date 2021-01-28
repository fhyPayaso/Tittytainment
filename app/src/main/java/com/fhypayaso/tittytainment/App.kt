package com.fhypayaso.tittytainment

import android.app.Application
import android.content.Context
import com.fhypayaso.network.HttpClient
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 10:34 PM
#   @Description   : 
# ====================================================*/
@HiltAndroidApp
class App : Application() {

    companion object {

        private lateinit var instance: Application


        fun instance(): Application {
            return instance
        }

    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        HttpClient.instance().init(this)


    }


}
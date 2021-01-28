package com.fhypayaso.tittytainment.account.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.base.BaseActivity
import com.fhypayaso.tittytainment.databinding.ActivityAccountBinding
import dagger.hilt.android.AndroidEntryPoint

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 10:58 AM
#   @Description   : 
# ====================================================*/
@AndroidEntryPoint
class AccountActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAccountBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}
package com.fhypayaso.tittytainment.movie

import android.view.View
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.base.BaseFragment
import com.fhypayaso.tittytainment.databinding.FragmentHomeBinding

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/26/21 12:04 AM
#   @Description   : 
# ====================================================*/
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun viewBinding(view: View): FragmentHomeBinding {
        return FragmentHomeBinding.bind(view)
    }

    override fun initView() {

    }

    override fun initViewModel() {

    }


}
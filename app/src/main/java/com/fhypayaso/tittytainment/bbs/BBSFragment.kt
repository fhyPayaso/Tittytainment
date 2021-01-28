package com.fhypayaso.tittytainment.bbs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.base.BaseFragment
import com.fhypayaso.tittytainment.databinding.FragmentBbsBinding

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/26/21 12:06 AM
#   @Description   : 
# ====================================================*/
class BBSFragment : BaseFragment<FragmentBbsBinding>(R.layout.fragment_bbs) {

    override fun viewBinding(view: View): FragmentBbsBinding {
        return FragmentBbsBinding.bind(view)
    }

    override fun initView() {

    }

    override fun initViewModel() {

    }


}
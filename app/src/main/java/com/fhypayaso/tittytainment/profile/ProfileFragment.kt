package com.fhypayaso.tittytainment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.base.BaseFragment
import com.fhypayaso.tittytainment.databinding.FragmentProfileBinding

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/26/21 12:05 AM
#   @Description   : 
# ====================================================*/
class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    override fun viewBinding(view: View): FragmentProfileBinding {
        return FragmentProfileBinding.bind(view)
    }

    override fun initView() {

    }

    override fun initViewModel() {

    }


}
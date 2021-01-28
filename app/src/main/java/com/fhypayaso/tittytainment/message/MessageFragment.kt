package com.fhypayaso.tittytainment.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.base.BaseFragment
import com.fhypayaso.tittytainment.databinding.FragmentMessageBinding

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/26/21 12:07 AM
#   @Description   :
# ====================================================*/
class MessageFragment : BaseFragment<FragmentMessageBinding>(R.layout.fragment_message) {

    override fun viewBinding(view: View): FragmentMessageBinding {
        return FragmentMessageBinding.bind(view)
    }

    override fun initView() {
    }

    override fun initViewModel() {

    }


}
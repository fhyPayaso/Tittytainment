package com.fhypayaso.tittytainment.account.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fhypayaso.tittytainment.MainActivity
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.databinding.FragmentAccountBinding
import kotlin.properties.Delegates

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 6:26 PM
#   @Description   : 
# ====================================================*/
abstract class AccountFragment : Fragment() {

    protected var isVisavle : Boolean = true

    private var _binding: FragmentAccountBinding? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    protected abstract fun initView()


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected fun checkParam(): Boolean {

        val phone = binding.editPhone.text
        if (phone.isNullOrEmpty()) {
            binding.editPhone.error = getString(R.string.error_empty_phone)
            return false
        }


        if (binding.layoutPassword.visibility == View.VISIBLE) {
            val password = binding.editPassword.text
            if (password.isNullOrEmpty()) {
                binding.editPassword.error = getString(R.string.error_empty_password)
                return false
            }
        }

        if (binding.layoutSms.visibility == View.VISIBLE) {
            val smsCode = binding.editSms.text
            if (smsCode.isNullOrEmpty()) {
                binding.editSms.error = getString(R.string.error_empty_sms)
                return false
            }
        }

        return true
    }


    protected fun goMainActivity() {
        MainActivity.startActivity(context)
        activity?.finish()
    }

}
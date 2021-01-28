package com.fhypayaso.tittytainment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/26/21 12:04 AM
#   @Description   : 
# ====================================================*/
abstract class BaseFragment : Fragment() {


//    protected var binding get() = _binding!!


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
////        return binding.root
//    }


    abstract fun layoutId(): Int


//    abstract fun initData()
//
//    abstract fun initView()


}
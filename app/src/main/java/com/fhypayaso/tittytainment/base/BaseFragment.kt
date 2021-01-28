package com.fhypayaso.tittytainment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/26/21 12:04 AM
#   @Description   : 
# ====================================================*/
abstract class BaseFragment<VB : ViewBinding>(val layoutId: Int) : Fragment() {


    private var _binding: VB? = null
    protected val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = viewBinding(view)
        initView()
        initViewModel()
    }

    abstract fun viewBinding(view: View): VB

    abstract fun initView()

    abstract fun initViewModel()

    //释放数据
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}
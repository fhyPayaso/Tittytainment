package com.fhypayaso.tittytainment.account.ui.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.fhypayaso.tittytainment.MainActivity
import com.fhypayaso.tittytainment.R
import com.fhypayaso.tittytainment.account.viewmodel.SplashViewModel
import com.fhypayaso.tittytainment.base.BaseFragment
import com.fhypayaso.tittytainment.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/28/21 8:31 PM
#   @Description   : 
# ====================================================*/
@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModels()

    override fun viewBinding(view: View): FragmentSplashBinding {
        return FragmentSplashBinding.bind(view)
    }

    override fun initView() {

    }

    override fun initViewModel() {
        viewModel.onSplashShow()
        viewModel.tokenStatusLiveData.observe(viewLifecycleOwner, Observer {
            if (it) {
                MainActivity.startActivity(context)
                activity?.finish()
            } else {
                Navigation.findNavController(binding.root).navigate(R.id.action_go_login)
            }
        })
    }
}
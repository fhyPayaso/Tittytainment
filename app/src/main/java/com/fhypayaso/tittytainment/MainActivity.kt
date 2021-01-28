package com.fhypayaso.tittytainment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.fhypayaso.tittytainment.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 11:00 PM
#   @Description   : 
# ====================================================*/
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private var currentNavController: LiveData<NavController>? = null



    companion object {

        fun startActivity(context: Context?) {

            val intent = Intent(context, MainActivity::class.java)
            context?.startActivity(intent)
        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    /**
     * 初始创建或杀进程恢复
     */
    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds =
            listOf(R.navigation.home, R.navigation.bbs, R.navigation.message, R.navigation.profile)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

//        // action bar同步
//        controller.observe(this, Observer { navController ->
//            setupActionBarWithNavController(navController)
//        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}
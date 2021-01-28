/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/28/21 11:24 AM
#   @Description   : 
# ====================================================*/

object Version {


    const val hilt = "2.28-alpha"
    const val hiltLifecycle = "1.0.0-alpha01"

}


object Libs {


}

object LibDagger {

    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltAndroidProcessor = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    const val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.hiltLifecycle}"
    const val hiltProcessor = "androidx.hilt:hilt-compiler:${Version.hiltLifecycle}"
}
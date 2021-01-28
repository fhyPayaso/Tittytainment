package com.fhypayaso.tittytainment.base.repository

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 7:11 PM
#   @Description   : 
# ====================================================*/
abstract class BaseRepository<F : BaseFetcher, C : BaseCache> constructor(
    private val fetcher: F,
    private val cache: C
) {

    fun fetcher(): F {
        return fetcher
    }

    fun cache(): C {
        return cache
    }

}
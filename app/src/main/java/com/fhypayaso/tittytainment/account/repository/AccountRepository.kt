package com.fhypayaso.tittytainment.account.repository

import com.fhypayaso.tittytainment.base.repository.BaseRepository

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 7:13 PM
#   @Description   : 
# ====================================================*/
class AccountRepository(fetcher: AccountFetcher, cache: AccountCache) :
    BaseRepository<AccountFetcher, AccountCache>(fetcher, cache)
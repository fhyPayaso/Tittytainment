package com.fhypayaso.tittytainment.account.di

import com.fhypayaso.network.HttpClient
import com.fhypayaso.tittytainment.account.repository.AccountCache
import com.fhypayaso.tittytainment.account.repository.AccountFetcher
import com.fhypayaso.tittytainment.account.repository.AccountRepository
import com.fhypayaso.tittytainment.account.repository.AccountService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 7:16 PM
#   @Description   : 
# ====================================================*/
@Module
@InstallIn(ActivityComponent::class)
object AccountModule {

    @Provides
    fun provideAccountService(): AccountService {
        return HttpClient.instance().createService(AccountService::class.java)
    }

    @Provides
    fun provideAccountCache(): AccountCache {
        return AccountCache()
    }

    @Provides
    fun provideAccountFetcher(accountService: AccountService): AccountFetcher {
        return AccountFetcher(accountService)
    }

    // 单例的作用域为activity
    @ActivityScoped
    @Provides
    fun provideAccountRepository(
        accountFetcher: AccountFetcher,
        accountCache: AccountCache
    ): AccountRepository {
        return AccountRepository(accountFetcher, accountCache)
    }


}
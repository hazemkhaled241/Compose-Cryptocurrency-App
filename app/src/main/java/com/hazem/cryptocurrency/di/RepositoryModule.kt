package com.hazem.cryptocurrency.di

import com.hazem.cryptocurrency.data.remote.CoinApi
import com.hazem.cryptocurrency.data.repository.CoinRepositoryImp
import com.hazem.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCoinRepository(coinApi: CoinApi):CoinRepository{
        return CoinRepositoryImp(coinApi)
    }
}
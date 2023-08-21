package com.hazem.cryptocurrency.data.repository

import com.hazem.cryptocurrency.data.remote.CoinApi
import com.hazem.cryptocurrency.data.remote.dto.CoinDto
import com.hazem.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }

}
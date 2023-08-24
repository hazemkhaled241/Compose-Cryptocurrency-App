package com.hazem.cryptocurrency.domain.repository
import com.hazem.cryptocurrency.domain.model.Coin
import com.hazem.cryptocurrency.domain.model.CoinDetail
import com.hazem.cryptocurrency.utils.Resource

interface CoinRepository {
    suspend fun getCoins(): Resource<List<Coin>,String>
    suspend fun getCoinById(coinId: String): Resource<CoinDetail, String>
}
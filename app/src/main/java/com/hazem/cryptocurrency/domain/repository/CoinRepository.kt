package com.hazem.cryptocurrency.domain.repository

import com.hazem.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
}
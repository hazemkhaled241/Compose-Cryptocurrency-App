package com.hazem.cryptocurrency.data.remote

import com.hazem.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>
}
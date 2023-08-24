package com.hazem.cryptocurrency.data.repository

import com.hazem.cryptocurrency.data.remote.CoinApi
import com.hazem.cryptocurrency.domain.model.Coin
import com.hazem.cryptocurrency.domain.model.CoinDetail
import com.hazem.cryptocurrency.domain.repository.CoinRepository
import com.hazem.cryptocurrency.utils.Resource
import com.hazem.cryptocurrency.utils.toCoin
import com.hazem.cryptocurrency.utils.toCoinDetail
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): Resource<List<Coin>,String> {
        return try {
            Resource.Success(coinApi.getCoins().map { it.toCoin() })
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")

        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail, String> {
        return try {
           Resource.Success (coinApi.getCoinById(coinId).toCoinDetail())
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage?:"An unexpected error occurred")
        } catch (e: IOException) {
           Resource.Error("Couldn't reach server. Check your internet connection.")
        }


    }

}
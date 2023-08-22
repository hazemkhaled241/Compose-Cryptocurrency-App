package com.hazem.cryptocurrency.domain.use_case

import com.hazem.cryptocurrency.domain.model.Coin
import com.hazem.cryptocurrency.domain.repository.CoinRepository
import com.hazem.cryptocurrency.utils.Resource
import com.hazem.cryptocurrency.utils.toCoin
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(): Resource<List<Coin>,String>{
       return try {
           // emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
             Resource.Success(coins)

        } catch (e: HttpException) {
             Resource.Error(e.localizedMessage ?: "An unexpected error occured")
        } catch (e: IOException) {
             Resource.Error("Couldn't reach server. Check your internet connection.")

        }
    }

}
package com.hazem.cryptocurrency.domain.use_case

import com.hazem.cryptocurrency.domain.model.Coin
import com.hazem.cryptocurrency.domain.repository.CoinRepository
import com.hazem.cryptocurrency.utils.Resource
import com.hazem.cryptocurrency.utils.toCoin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))

        }
    }

}
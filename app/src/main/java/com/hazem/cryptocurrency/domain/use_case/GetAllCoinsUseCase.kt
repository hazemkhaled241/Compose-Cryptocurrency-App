package com.hazem.cryptocurrency.domain.use_case

import com.hazem.cryptocurrency.domain.model.Coin
import com.hazem.cryptocurrency.domain.repository.CoinRepository
import com.hazem.cryptocurrency.utils.Resource
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(): Resource<List<Coin>,String>{
     return coinRepository.getCoins()
    }

}
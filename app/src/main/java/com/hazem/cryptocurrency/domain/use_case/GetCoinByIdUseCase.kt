package com.hazem.cryptocurrency.domain.use_case

import com.hazem.cryptocurrency.domain.model.CoinDetail
import com.hazem.cryptocurrency.domain.repository.CoinRepository
import com.hazem.cryptocurrency.utils.Resource
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(coinId: String): Resource<CoinDetail, String> {
        return coinRepository.getCoinById(coinId)
    }
}
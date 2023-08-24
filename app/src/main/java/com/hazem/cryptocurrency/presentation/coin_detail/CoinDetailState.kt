package com.hazem.cryptocurrency.presentation.coin_detail

import com.hazem.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val coinDetail: CoinDetail? = null,
    val errorMessage:String="",
    val isLoading:Boolean=false
)

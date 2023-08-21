package com.hazem.cryptocurrency.presentation.coin_list

import com.hazem.cryptocurrency.domain.model.Coin

data class CoinListState(
    val coins: List<Coin> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = false
)

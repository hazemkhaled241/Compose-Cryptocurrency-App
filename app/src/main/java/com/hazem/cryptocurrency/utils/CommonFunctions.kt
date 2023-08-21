package com.hazem.cryptocurrency.utils

import com.hazem.cryptocurrency.data.remote.dto.CoinDto
import com.hazem.cryptocurrency.domain.model.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = this.id,
        isActive = this.isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
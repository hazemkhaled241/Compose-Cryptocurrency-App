package com.hazem.cryptocurrency.utils

import com.hazem.cryptocurrency.data.remote.dto.CoinDetailDto
import com.hazem.cryptocurrency.data.remote.dto.CoinDto
import com.hazem.cryptocurrency.domain.model.Coin
import com.hazem.cryptocurrency.domain.model.CoinDetail

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = this.id,
        isActive = this.isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}
package com.kichou.imad.cryptocurrency.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kichou.imad.cryptocurrency.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)


fun CoinDto.toCoin() : Coin {
    return Coin(
        id,
        isActive,
        name,
        rank,
        symbol
    )
}
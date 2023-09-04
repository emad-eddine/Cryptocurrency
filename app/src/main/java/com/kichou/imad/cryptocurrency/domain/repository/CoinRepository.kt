package com.kichou.imad.cryptocurrency.domain.repository

import com.kichou.imad.cryptocurrency.data.remote.dto.CoinDetailDto
import com.kichou.imad.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {


    suspend fun getAllCoins() : List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto



}
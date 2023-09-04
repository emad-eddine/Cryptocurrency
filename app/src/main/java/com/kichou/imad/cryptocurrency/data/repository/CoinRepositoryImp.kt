package com.kichou.imad.cryptocurrency.data.repository

import com.kichou.imad.cryptocurrency.data.remote.CoinPaprikaApi
import com.kichou.imad.cryptocurrency.data.remote.dto.CoinDetailDto
import com.kichou.imad.cryptocurrency.data.remote.dto.CoinDto
import com.kichou.imad.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi) : CoinRepository{


    override suspend fun getAllCoins() : List<CoinDto>{
        return coinPaprikaApi.getCoinsList()
    }

    override suspend fun getCoinById(coinId : String) : CoinDetailDto{
        return coinPaprikaApi.getCoinById(coinId)
    }



}
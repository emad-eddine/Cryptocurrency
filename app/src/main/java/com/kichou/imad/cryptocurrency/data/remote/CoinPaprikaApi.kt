package com.kichou.imad.cryptocurrency.data.remote

import com.kichou.imad.cryptocurrency.data.remote.dto.CoinDetailDto
import com.kichou.imad.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {


    @GET("/v1/coins")
    suspend fun getCoinsList() : List<CoinDto>

    @GET("/V1/coins/{coidId}")
    suspend fun getCoinById(
        @Path("coindId") coindId : String,
    ) : CoinDetailDto



}
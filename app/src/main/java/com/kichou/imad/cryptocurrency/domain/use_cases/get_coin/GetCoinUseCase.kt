package com.kichou.imad.cryptocurrency.domain.use_cases.get_coin

import com.kichou.imad.cryptocurrency.common.Resource
import com.kichou.imad.cryptocurrency.data.remote.dto.toCoin
import com.kichou.imad.cryptocurrency.data.remote.dto.toCoindDetail
import com.kichou.imad.cryptocurrency.domain.model.Coin
import com.kichou.imad.cryptocurrency.domain.model.CoinDetail
import com.kichou.imad.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository){

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {

        try {

             emit(Resource.Loading<CoinDetail>())


             val coin = repository.getCoinById(coinId).toCoindDetail()

            println("coin value ${coin.name}")

            emit(Resource.Success<CoinDetail>(data = coin))

        }catch (e : HttpException){

            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error"))

        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach the server"))
        }



    }



}
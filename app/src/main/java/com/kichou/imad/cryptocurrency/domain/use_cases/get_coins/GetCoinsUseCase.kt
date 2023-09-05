package com.kichou.imad.cryptocurrency.domain.use_cases.get_coins

import com.kichou.imad.cryptocurrency.common.Resource
import com.kichou.imad.cryptocurrency.data.remote.dto.toCoin
import com.kichou.imad.cryptocurrency.domain.model.Coin
import com.kichou.imad.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository : CoinRepository){

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {

        try {

             emit(Resource.Loading<List<Coin>>())
             val coins = repository.getAllCoins().map {
                 it.toCoin()
             }

            emit(Resource.Success<List<Coin>>(coins))

        }catch (e : HttpException){

            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error"))

        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach the server"))
        }



    }



}
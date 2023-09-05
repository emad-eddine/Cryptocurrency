package com.kichou.imad.cryptocurrency.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kichou.imad.cryptocurrency.common.Constants.PARAM_COIN_ID
import com.kichou.imad.cryptocurrency.common.Resource
import com.kichou.imad.cryptocurrency.domain.model.CoinDetail
import com.kichou.imad.cryptocurrency.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(

    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle) : ViewModel() {


        private val _state = mutableStateOf(CoinDetailState())

        val state : State<CoinDetailState> = _state

        init {
            savedStateHandle.get<String>(PARAM_COIN_ID)?.let {coinId->
                getCoin(coinId)
            }
        }


        private fun getCoin(coinId : String) {

            getCoinUseCase(coinId).onEach { result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = CoinDetailState(coin = result.data)
                    }

                    is Resource.Loading -> {
                        _state.value = CoinDetailState(isLoading = true)
                    }

                    is Resource.Error -> {
                        _state.value = CoinDetailState(error = result.message ?: "Un Error Occurred")
                    }
                }
            }.launchIn(viewModelScope)
        }

}
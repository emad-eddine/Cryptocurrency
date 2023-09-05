package com.kichou.imad.cryptocurrency.presentation.coin_details

import com.kichou.imad.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(

    val isLoading : Boolean = false,

    val coin : CoinDetail ?= null,

    val error : String = ""

)

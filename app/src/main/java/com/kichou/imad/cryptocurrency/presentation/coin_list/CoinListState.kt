package com.kichou.imad.cryptocurrency.presentation.coin_list

import com.kichou.imad.cryptocurrency.domain.model.Coin

data class CoinListState(

    val isLoading : Boolean = false,

    val coins : List<Coin> = emptyList(),

    val error : String = ""

)

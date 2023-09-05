package com.kichou.imad.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kichou.imad.cryptocurrency.presentation.coin_details.CoinDetailScreen
import com.kichou.imad.cryptocurrency.presentation.coin_list.CoinListScreen
import com.kichou.imad.cryptocurrency.presentation.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route){

                        composable(route = Screen.CoinListScreen.route){
                            CoinListScreen(navController)
                        }

                        composable(route = Screen.CoinDetailScreen.route +"/{coinId}"){


                            CoinDetailScreen()

                        }


                    }

                }
            }
        }
    }
}

package com.hazem.cryptocurrency.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hazem.cryptocurrency.presentation.coin_list.component.CoinListItem
import com.hazem.cryptocurrency.utils.Screen

@Composable
fun CoinListScreen(
    coinListViewModel: CoinListViewModel = hiltViewModel(),
    navController:NavController
) {
    val stateValue = coinListViewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(stateValue.coins) {coin->
           CoinListItem(coin = coin, onItemSelected = {
               navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
           })
            }
        }
        if(stateValue.errorMessage.isNotBlank()) {
            Text(
                text = stateValue.errorMessage,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(stateValue.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = Color.Green)
        }
    }
}
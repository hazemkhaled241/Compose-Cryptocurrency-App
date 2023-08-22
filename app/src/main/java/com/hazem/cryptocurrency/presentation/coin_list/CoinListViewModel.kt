package com.hazem.cryptocurrency.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.cryptocurrency.domain.use_case.GetAllCoinsUseCase
import com.hazem.cryptocurrency.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getAllCoinsUseCase: GetAllCoinsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        fetchAllCoins()
    }

    private fun fetchAllCoins() {
        viewModelScope.launch {
            _state.value = CoinListState(isLoading = true)
            getAllCoinsUseCase().let {
                when (it) {
                    is Resource.Success -> {
                        _state.value = CoinListState(isLoading = false)
                        _state.value = CoinListState(coins = it.data)
                    }

                    /* is Resource.Loading ->{
                         _state.value = CoinListState(isLoading = true)

                     }*/
                    is Resource.Error -> {
                        _state.value = CoinListState(isLoading = false)
                        _state.value = CoinListState(
                            errorMessage = it.message
                        )

                    }
                }
            }
        }

    }
}
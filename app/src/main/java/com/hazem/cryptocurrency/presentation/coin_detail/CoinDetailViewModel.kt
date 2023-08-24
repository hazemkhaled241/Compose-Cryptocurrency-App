package com.hazem.cryptocurrency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.cryptocurrency.domain.use_case.GetCoinByIdUseCase
import com.hazem.cryptocurrency.utils.Constants
import com.hazem.cryptocurrency.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val coinDetailStata: State<CoinDetailState> = _coinDetailState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            fetchCoinDetailsById(coinId)
        }
    }

    private fun fetchCoinDetailsById(coinId: String) {
        viewModelScope.launch {
            _coinDetailState.value = CoinDetailState(isLoading = true)
            getCoinByIdUseCase(coinId).let {
                when (it) {
                    is Resource.Success -> {
                        _coinDetailState.value = CoinDetailState(isLoading = false)
                        _coinDetailState.value = CoinDetailState(coinDetail = it.data)
                    }

                    is Resource.Error -> {
                        _coinDetailState.value = CoinDetailState(isLoading = false)
                        _coinDetailState.value = CoinDetailState(
                            errorMessage = it.message
                        )

                    }
                }
            }
        }

    }
}
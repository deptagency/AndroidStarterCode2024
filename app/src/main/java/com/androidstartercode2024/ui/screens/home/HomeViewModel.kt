package com.androidstartercode2024.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstartercode2024.domain.usecases.GetAnswerUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel (
    private val getAnswerUseCase: GetAnswerUseCase
) : ViewModel() {
    sealed class HomeUiState {
        data class Idle(val answer: Boolean) : HomeUiState()
        data object Loading : HomeUiState()
        data class Error(val errorMessage: String): HomeUiState()
    }

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle(false))
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            _homeUiState.emit(HomeUiState.Loading)
            delay(500)

            val answer = getAnswerUseCase().getOrNull()

            delay(250)
            if (answer != null) {
                _homeUiState.emit(HomeUiState.Idle(answer))
            } else {
                _homeUiState.emit(HomeUiState.Error("Unable to fetch answer."))
            }
        }
    }
}
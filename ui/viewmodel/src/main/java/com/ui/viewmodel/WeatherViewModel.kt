package com.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecase.WeatherUseCase
import com.ui.mapper.toCurrentWeatherUiState
import com.ui.uistate.WeatherMainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: WeatherUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherMainUiState())
    val weatherUiState get() = _state.asStateFlow()

    init {
        getCurrentWeatherByLatLon()
    }

    private fun getCurrentWeatherByLatLon() {
        viewModelScope.launch {
            try {
                _state.update { state ->
                    state.copy(
                        currentWeather = getWeatherUseCase(
                            "cairo"
                        ).toCurrentWeatherUiState(),
                        isLoading = false,
                        isSuccessful = true
                    )
                }
            } catch (e: Exception) {
                _state.value = WeatherMainUiState(
                    currentWeather = null,
                    isError = true,
                    isLoading = false,
                    isSuccessful = false
                )
            }
        }
    }
}
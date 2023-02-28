package com.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecase.GetCurrentWeatherByLatLonUseCase
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
    val getCurrentWeatherByLatLonUseCase: GetCurrentWeatherByLatLonUseCase
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
                        currentWeather = getCurrentWeatherByLatLonUseCase(
                            lat = 30.0444,
                            lon = 31.2357
                        ).map { currentWeather ->
                            currentWeather.toCurrentWeatherUiState()
                        },
                        isLoading = false,
                        isSuccessful = true
                    )
                }
            } catch (e: Exception) {
                _state.value = WeatherMainUiState(
                    currentWeather = emptyList(),
                    isError = true,
                    isLoading = false,
                    isSuccessful = false
                )
            }
        }
    }
}
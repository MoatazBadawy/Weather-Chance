package com.ui.uistate

data class WeatherMainUiState(
    val currentWeather: CurrentWeatherUiState? = CurrentWeatherUiState(),
    val isSuccessful: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false
)
package com.ui.uistate

data class WeatherMainUiState(
    val currentWeather: List<CurrentWeatherUiState> = emptyList(),
    val isSuccessful: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false
)
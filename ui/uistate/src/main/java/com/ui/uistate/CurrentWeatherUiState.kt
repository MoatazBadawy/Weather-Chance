package com.ui.uistate

data class CurrentWeatherUiState(
    val cityName: String = "",
    val temperature: String = "",
    val weather: String = "",
    val sunset: String = "",
    val windSpeed: String = "",
    val humidity: String = "",
)
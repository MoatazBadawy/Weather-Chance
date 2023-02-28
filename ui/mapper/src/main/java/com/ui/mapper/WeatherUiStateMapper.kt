package com.ui.mapper

import com.domain.model.Weather
import com.ui.uistate.CurrentWeatherUiState

fun Weather.toCurrentWeatherUiState() = CurrentWeatherUiState(
    cityName = location?.cityName.toString(),
    temperature = current?.tempC.toString(),
    weather = current?.condition?.text.toString(),
    sunset = current?.pressureIn.toString(),
    windSpeed = current?.windMph.toString(),
    humidity = current?.humidity.toString()
)
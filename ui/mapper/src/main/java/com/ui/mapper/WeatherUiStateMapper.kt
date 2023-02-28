package com.ui.mapper

import com.domain.entity.CurrentWeather
import com.ui.uistate.CurrentWeatherUiState

fun CurrentWeather.toCurrentWeatherUiState() = CurrentWeatherUiState(
    cityName = cityName,
    temperature = temp.toString(),
    weather = weather.description,
    sunset = sunset,
    windSpeed = windSpd.toInt().toString(),
    humidity = rh.toInt().toString()
)
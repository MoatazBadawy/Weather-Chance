package com.moataz.weather.data.model

data class WeatherResponse(
    val count: Int,
    val data: List<Data>
)
package com.core.remote.response.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val currentWeather: List<CurrentWeatherDto>
)
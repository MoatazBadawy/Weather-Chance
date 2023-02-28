package com.core.remote.response.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(
    @SerializedName("location")
    val locationDto: LocationDto,
    @SerializedName("current")
    val currentDto: CurrentDto
)
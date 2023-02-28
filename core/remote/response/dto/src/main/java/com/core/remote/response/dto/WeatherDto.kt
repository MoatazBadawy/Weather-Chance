package com.core.remote.response.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("code")
    val code: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)
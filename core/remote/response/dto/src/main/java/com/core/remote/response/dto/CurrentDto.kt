package com.core.remote.response.dto

import com.google.gson.annotations.SerializedName

data class CurrentDto(
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("temp_c")
    val tempC: Int?,
    @SerializedName("temp_f")
    val tempF: Double?,
    @SerializedName("is_day")
    val isDay: Int?,
    @SerializedName("condition")
    val conditionDto: ConditionDto?,
    @SerializedName("wind_mph")
    val windMph: Double?,
    @SerializedName("wind_kph")
    val windKph: Double?,
    @SerializedName("wind_degree")
    val windDegree: Int?,
    @SerializedName("wind_dir")
    val windDir: String?,
    @SerializedName("pressure_mb")
    val pressureMb: Int?,
    @SerializedName("pressure_in")
    val pressureIn: Int?,
    @SerializedName("precip_mm")
    val precipMm: Int?,
    @SerializedName("precip_in")
    val precipIn: Int?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("cloud")
    val cloud: Int?,
    @SerializedName("feelslike_c")
    val feelslikeC: Double?,
    @SerializedName("feelslike_f")
    val feelslikeF: Double?,
    @SerializedName("vis_km")
    val visKm: Int?,
    @SerializedName("vis_miles")
    val visMiles: Int?,
    @SerializedName("uv")
    val uv: Int?,
    @SerializedName("gust_mph")
    val gustMph: Double?,
    @SerializedName("gust_kph")
    val gustKph: Double?
)
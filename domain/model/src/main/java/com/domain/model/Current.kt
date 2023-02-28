package com.domain.model

data class Current(
    val lastUpdatedEpoch: Int?,
    val lastUpdated: String?,
    val tempC: Double?,
    val tempF: Double?,
    val isDay: Int?,
    val condition: Condition?,
    val windMph: Double?,
    val windKph: Double?,
    val windDegree: Int?,
    val windDir: String?,
    val pressureMb: Double?,
    val pressureIn: Double?,
    val precipMm: Double?,
    val precipIn: Double?,
    val humidity: Int?,
    val cloud: Int?,
    val feelslikeC: Double?,
    val feelslikeF: Double?,
    val visKm: Double?,
    val visMiles: Double?,
    val uv: Double?,
    val gustMph: Double?,
    val gustKph: Double?
)

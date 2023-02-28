package com.domain.model

data class Location(
    val cityName: String?,
    val region: String?,
    val country: String?,
    val lat: Double?,
    val lon: Double?,
    val timeZoneId: String?,
    val localtimeEpoch: Int?,
    val localtime: String?
)
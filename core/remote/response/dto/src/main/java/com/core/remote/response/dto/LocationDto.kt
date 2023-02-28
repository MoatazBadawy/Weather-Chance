package com.core.remote.response.dto

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("name")
    val cityName: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("tz_id")
    val timeZoneId: String?,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int?,
    @SerializedName("localtime")
    val localtime: String?
)
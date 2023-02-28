package com.core.remote.service

import com.core.remote.response.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current")
    suspend fun getCurrentWeatherByLatLon(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): WeatherResponseDto
}
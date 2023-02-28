package com.core.remote.service

import com.core.remote.response.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.json")
    suspend fun getCurrentWeatherByCity(
        @Query("q") cityName: String
    ): WeatherResponseDto
}
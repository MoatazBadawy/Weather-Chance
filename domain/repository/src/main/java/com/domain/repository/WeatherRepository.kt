package com.domain.repository

import com.core.remote.response.dto.WeatherResponseDto

interface WeatherRepository {
    suspend fun getCurrentWeatherByCity(cityName: String): WeatherResponseDto
}
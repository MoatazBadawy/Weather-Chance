package com.domain.repository

import com.core.remote.response.dto.WeatherResponseDto

interface WeatherRepository {
    suspend fun getCurrentWeatherByLatLon(lat: Double, lon: Double): WeatherResponseDto
}
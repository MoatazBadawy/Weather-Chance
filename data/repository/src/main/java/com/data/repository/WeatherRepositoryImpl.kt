package com.data.repository

import com.core.remote.response.dto.WeatherResponseDto
import com.core.remote.service.WeatherService
import com.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService
) : WeatherRepository {
    override suspend fun getCurrentWeatherByLatLon(lat: Double, lon: Double): WeatherResponseDto {
        return weatherService.getCurrentWeatherByLatLon(lat, lon)
    }
}
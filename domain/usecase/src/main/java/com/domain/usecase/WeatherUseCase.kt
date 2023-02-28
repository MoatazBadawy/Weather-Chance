package com.domain.usecase

import com.domain.mapper.toWeather
import com.domain.model.Weather
import com.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(cityName: String): Weather {
        return weatherRepository.getCurrentWeatherByCity(cityName).toWeather()
    }
}
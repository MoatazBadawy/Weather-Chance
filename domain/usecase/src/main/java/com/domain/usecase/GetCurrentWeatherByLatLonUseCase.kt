package com.domain.usecase

import android.util.Log
import com.domain.entity.CurrentWeather
import com.domain.mapper.toCurrentWeather
import com.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherByLatLonUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(lat: Double, lon: Double): List<CurrentWeather> {
        val weather = repository.getCurrentWeatherByLatLon(lat, lon).currentWeather.map {
            it.toCurrentWeather()
        }
        Log.v("DOMAINOI", "weather: $weather")
        return weather
    }
}
package com.domain.mapper

import com.core.remote.response.dto.ConditionDto
import com.core.remote.response.dto.CurrentDto
import com.core.remote.response.dto.LocationDto
import com.core.remote.response.dto.WeatherResponseDto
import com.domain.model.Condition
import com.domain.model.Current
import com.domain.model.Location
import com.domain.model.Weather


fun WeatherResponseDto.toWeather(): Weather {
    return Weather(
        location = locationDto.toLocation(),
        current = currentDto.toCurrent()
    )
}

fun LocationDto.toLocation(): Location {
    return Location(
        cityName = cityName,
        country = country,
        region = region,
        lat = lat,
        lon = lon,
        timeZoneId = timeZoneId,
        localtimeEpoch = localtimeEpoch,
        localtime = localtime
    )
}

fun CurrentDto.toCurrent(): Current {
    return Current(
        condition = conditionDto?.toCondition(),
        tempC = tempC?.toDouble(),
        tempF = tempF,
        isDay = isDay,
        windMph = windMph,
        windKph = windKph,
        windDegree = windDegree,
        windDir = windDir,
        pressureMb = pressureMb?.toDouble(),
        pressureIn = pressureIn?.toDouble(),
        precipMm = precipMm?.toDouble(),
        precipIn = precipIn?.toDouble(),
        humidity = humidity,
        cloud = cloud,
        feelslikeC = feelslikeC,
        feelslikeF = feelslikeF,
        visKm = visKm?.toDouble(),
        visMiles = visMiles?.toDouble(),
        uv = uv?.toDouble(),
        gustMph = gustMph,
        gustKph = gustKph,
        lastUpdated = lastUpdated,
        lastUpdatedEpoch = lastUpdatedEpoch
    )
}

fun ConditionDto.toCondition(): Condition {
    return Condition(
        text = text,
        code = code,
        icon = icon
    )
}
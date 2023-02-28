package com.domain.mapper

import com.core.remote.response.dto.CurrentWeatherDto
import com.core.remote.response.dto.WeatherDto
import com.domain.entity.CurrentWeather
import com.domain.entity.Weather

fun WeatherDto.toWeather(): Weather {
    return Weather(
        code = code, description = description, icon = icon
    )
}

fun CurrentWeatherDto.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        appTemp = appTemp,
        aqi = aqi,
        cityName = cityName,
        clouds = clouds,
        countryCode = countryCode,
        dateTime = dateTime,
        dewpt = dewpt,
        dhi = dhi,
        dni = dni,
        elevAngle = elevAngle,
        ghi = ghi,
        hAngle = hAngle,
        latitude = latitude,
        longitude = longitude,
        obTime = obTime,
        pod = pod,
        precip = precip,
        pres = pres,
        rh = rh,
        slp = slp,
        snow = snow,
        solarRad = solarRad,
        stateCode = stateCode,
        station = station,
        sunrise = sunrise,
        sunset = sunset,
        temp = temp,
        timezone = timezone,
        ts = ts,
        uv = uv,
        vis = vis,
        weather = weather.toWeather(),
        windCdir = windCdir,
        windCdirFull = windCdirFull,
        windDir = windDir,
        windSpd = windSpd
    )
}
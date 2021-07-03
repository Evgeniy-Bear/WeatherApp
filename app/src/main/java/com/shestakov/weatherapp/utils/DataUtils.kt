package com.shestakov.weatherapp.utils

import com.shestakov.weatherapp.model.FactDTO
import com.shestakov.weatherapp.model.Weather
import com.shestakov.weatherapp.model.WeatherDTO
import com.shestakov.weatherapp.model.getDefaultCity

fun convertDtoToModel(weatherDTO: WeatherDTO): List<Weather> {
    val fact: FactDTO = weatherDTO.fact!!
    return listOf(
        Weather(
            getDefaultCity(), fact.temp!!, fact.feels_like!!, fact.condition!!,
            fact.icon
        )
    )
}

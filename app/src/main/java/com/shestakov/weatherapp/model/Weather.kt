package com.shestakov.weatherapp.model

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
)

fun getDefaultCity() = City(cityName = "Россия, Тюмень", lat = 58.1143, lon = 68.1529)
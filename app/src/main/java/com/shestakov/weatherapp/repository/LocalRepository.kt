package com.shestakov.weatherapp.repository

import com.shestakov.weatherapp.model.Weather

interface LocalRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}
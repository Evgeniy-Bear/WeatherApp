package com.shestakov.weatherapp.repository

import com.shestakov.weatherapp.model.Weather
import com.shestakov.weatherapp.model.getRussianCities
import com.shestakov.weatherapp.model.getWorldCities

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorageRus() = getRussianCities()

    override fun getWeatherFromLocalStorageWorld() = getWorldCities()
}
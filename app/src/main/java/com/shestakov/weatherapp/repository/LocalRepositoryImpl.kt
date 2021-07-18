package com.shestakov.weatherapp.repository

import com.shestakov.weatherapp.model.Weather
import com.shestakov.weatherapp.room.HistoryDao
import com.shestakov.weatherapp.utils.convertHistoryEntityToWeather
import com.shestakov.weatherapp.utils.convertWeatherToEntity

class LocalRepositoryImpl(private val localDataSource: HistoryDao) : LocalRepository {
    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        localDataSource.insert(convertWeatherToEntity(weather))
    }
}
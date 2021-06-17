package com.shestakov.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shestakov.weatherapp.model.Repository
import com.shestakov.weatherapp.model.RepositoryImpl

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1500)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocalStorage()))
        }.start()
    }
}
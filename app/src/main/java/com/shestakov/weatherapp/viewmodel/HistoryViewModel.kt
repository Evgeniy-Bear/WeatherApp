package com.shestakov.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shestakov.weatherapp.app.App
import com.shestakov.weatherapp.repository.LocalRepository
import com.shestakov.weatherapp.repository.LocalRepositoryImpl

class HistoryViewModel(
        val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
        private val historyRepository: LocalRepository = LocalRepositoryImpl(App.getHistoryDao())
) : ViewModel() {

    fun getAllHistory() {
        historyLiveData.value = AppState.Loading
        historyLiveData.value = AppState.Success(historyRepository.getAllHistory())
    }
}
package com.shestakov.weatherapp.app

import android.app.Application
import androidx.room.Room
import com.shestakov.weatherapp.room.HistoryDao
import com.shestakov.weatherapp.room.HistoryDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {

        private var appInstance: App? = null
        private var db: HistoryDatabase? = null
        private const val DB_NAME = "History.db"

        private val appHistoryDao by lazy {
            Room
                    .databaseBuilder(
                            appInstance!!.applicationContext,
                            HistoryDatabase::class.java,
                            DB_NAME
                    )
                    .allowMainThreadQueries()
                    .build()
                    .historyDao()
        }

        fun getHistoryDao(): HistoryDao = appHistoryDao
    }
}
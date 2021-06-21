package com.shestakov.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
        val city: City = getDefaultCity(),
        val temperature: Int = 0,
        val feelsLike: Int = 0
) : Parcelable

fun getDefaultCity() = City(cityName = "Хабаровск", lat = 48.482, lon = 135.084)

fun getRussianCities(): List<Weather> {
    return listOf(
            Weather(City("Москва", 55.755, 37.617), 1, 1),
            Weather(City("Санкт-Петербург", 59.934, 30.335), 2, 2),
            Weather(City("Новосибирск", 55.008, 82.935), 3, 3),
            Weather(City("Екатеринбург", 56.838, 60.605), 4, 4),
            Weather(City("Нижний Новгород", 56.296, 43.936), 5, 5),
            Weather(City("Казань", 55.830, 49.066), 6, 6),
            Weather(City("Челябинск", 55.164, 61.436), 7, 7),
            Weather(City("Омск", 54.988, 73.324), 8, 8),
            Weather(City("Ростов-на-Дону", 47.235, 39.701), 9, 9),
            Weather(City("Хабаровск", 48.482, 135.084), 10, 10)
    )
}

fun getWorldCities(): List<Weather> {
    return listOf(
            Weather(City("Лондон", 51.5085300, -0.125), 11, 1),
            Weather(City("Токио", 35.6895000, 139.691), 12, 2),
            Weather(City("Париж", 48.8534100, 2.3488000), 13, 3),
            Weather(City("Берлин", 52.52000659999999, 13.404953999999975), 14, 4),
            Weather(City("Рим", 41.9027835, 12.496), 15, 5),
            Weather(City("Минск", 53.90453979999999, 27.561524400000053), 16, 6),
            Weather(City("Стамбул", 41.0082376, 28.97835889999999), 17, 7),
            Weather(City("Вашингтон", 38.9071923, -77.03687070000001), 18, 8),
            Weather(City("Киев", 50.4501, 30.523400000000038), 19, 9),
            Weather(City("Пекин", 39.90419989999999, 116.40739630000007), 20, 10)
    )
}
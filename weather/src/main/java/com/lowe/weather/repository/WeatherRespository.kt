package com.lowe.weather.repository

import com.lowe.core.network.Callback
import com.lowe.weather.di.model.WeatherItem

interface WeatherRespository {
  fun getWeatherForcast(
    cityName: String,callBack : Callback<List<WeatherItem>>
  )

}
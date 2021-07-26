package com.lowe.weather.repository

import com.lowe.weather.di.model.WeatherItem
import com.lowe.weather.di.model.WeatherListResponse
import com.lowe.weather.di.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * [WeatherRespository] implementation for Loyalty Registration endpoints.
 */
class WeatherRespositoryImpl @Inject constructor(private val weatherApi: WeatherApi
) : WeatherRespository {

  override fun getWeatherForcast(
    cityName: String,
    callBack: com.lowe.core.network.Callback<List<WeatherItem>>
  ) {
    val call: Call<WeatherListResponse> =
      weatherApi.getWeatherForcast("Rome", "65d00499677e59496ca2f318eb68c049")
    call.enqueue(object : Callback<WeatherListResponse> {
      override fun onResponse(
        call: Call<WeatherListResponse>,
        response: Response<WeatherListResponse>
      ) {
        val weatherListResponse = response.body()
        callBack.onSuccess(weatherListResponse!!.list)
      }

      override fun onFailure(
        call: Call<WeatherListResponse>,
        t: Throwable
      ) {
        callBack.onFailure(t)
      }
    })
  }

}
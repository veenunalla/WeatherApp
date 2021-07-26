package com.lowe.weather.di.network

import com.lowe.weather.di.model.WeatherListResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/forecast")
    fun getWeatherForcast(
        @Query("q") cityName: String,@Query("appid") appId: String): Call<WeatherListResponse>
}
package com.lowe.weather.di.model


import com.google.gson.annotations.SerializedName

data class WeatherListResponse(
    @SerializedName("city")
    val city: City?,
    @SerializedName("cnt")
    val cnt: Int?,
    @SerializedName("cod")
    val cod: String?,
    @SerializedName("list")
    val list: List<WeatherItem> = mutableListOf(),
    @SerializedName("message")
    val message: Int?
)
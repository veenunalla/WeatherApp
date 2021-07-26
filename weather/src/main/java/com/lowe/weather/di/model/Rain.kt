package com.lowe.weather.di.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Rain(
    @SerializedName("3h")
    val h: Double?
): Serializable
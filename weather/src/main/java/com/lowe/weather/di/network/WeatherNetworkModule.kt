package com.lowe.weather.di.network

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lowe.core.network.ServiceFactory
import com.lowe.weather.repository.WeatherRespository
import com.lowe.weather.repository.WeatherRespositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class WeatherNetworkModule {

    @Provides
    @NonNull
    fun provideLoyaltyRegistrationService(
        @NonNull context: Context,
        @NonNull serviceFactory: ServiceFactory
    ): WeatherApi {
        val baseUrl = "https://api.openweathermap.org/"
        return serviceFactory.create(baseUrl, WeatherApi::class.java)
    }
    @Provides
    @Singleton
    @NonNull
    fun provideRepositoryImpl(repository: WeatherRespositoryImpl): WeatherRespository {
        return repository
    }
}
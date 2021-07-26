package com.lowe.weather.di.module

import com.lowe.core.ViewModelModule
import com.lowe.weather.di.network.WeatherNetworkModule
import com.lowe.weather.ui.city_search.di.CitySearchFragmentModule
import com.lowe.weather.ui.weatherlist.di.WeatherListModule
import com.lowe.weather.ui.weatherlist_detail.di.WeatherListDetailModule
import dagger.Module

@Module(includes = [
  WeatherNetworkModule::class,
  WeatherListModule::class,
  ViewModelModule::class,
  WeatherListDetailModule::class,
  CitySearchFragmentModule::class
])
interface WeatherModule
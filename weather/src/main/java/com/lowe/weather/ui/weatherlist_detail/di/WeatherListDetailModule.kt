package com.lowe.weather.ui.weatherlist_detail.di

import com.lowe.core.scopes.FragmentScope
import com.lowe.weather.ui.weatherlist_detail.WeatherListDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface WeatherListDetailModule {

  @FragmentScope
  @ContributesAndroidInjector(modules = [WeatherListDetailVmModule::class])
  fun contributeWeatherListInjector(): WeatherListDetailFragment
}
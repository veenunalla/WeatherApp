package com.lowe.weather.ui.weatherlist.di

import com.lowe.core.scopes.FragmentScope
import com.lowe.weather.ui.weatherlist.WeatherListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface WeatherListModule {

  @FragmentScope
  @ContributesAndroidInjector(modules = [WeatherListVmModule::class])
  fun contributeWeatherListInjector(): WeatherListFragment
}
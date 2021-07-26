package com.lowe.weather.ui.city_search.di

import com.lowe.core.scopes.FragmentScope
import com.lowe.weather.ui.city_search.CitySearchFragment
import com.lowe.weather.ui.weatherlist.WeatherListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CitySearchFragmentModule {

  @FragmentScope
  @ContributesAndroidInjector(modules = [CitySearchVmModule::class])
  fun contributeCityFragmentInjector(): CitySearchFragment
}
package com.lowe.weather.ui.city_search.di

import androidx.lifecycle.ViewModel
import com.lowe.core.ViewModelKey
import com.lowe.weather.ui.city_search.CitySearchViewModel
import com.lowe.weather.ui.weatherlist.WeatherListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
public interface CitySearchVmModule {

  @Binds
  @IntoMap
  @ViewModelKey(CitySearchViewModel::class)
  fun bindCitySearchViewModel(citySearchViewModel: CitySearchViewModel): ViewModel
}
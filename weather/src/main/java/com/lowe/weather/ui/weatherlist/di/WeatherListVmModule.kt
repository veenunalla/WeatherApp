package com.lowe.weather.ui.weatherlist.di

import androidx.lifecycle.ViewModel
import com.lowe.core.ViewModelKey
import com.lowe.weather.ui.weatherlist.WeatherListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
public interface WeatherListVmModule {

  @Binds
  @IntoMap
  @ViewModelKey(WeatherListViewModel::class)
  fun bindWeatherListViewModel(weatherListViewModel: WeatherListViewModel): ViewModel
}
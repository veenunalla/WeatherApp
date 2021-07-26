package com.lowe.weather.ui.weatherlist_detail.di

import androidx.lifecycle.ViewModel
import com.lowe.core.ViewModelKey
import com.lowe.weather.ui.weatherlist.WeatherListViewModel
import com.lowe.weather.ui.weatherlist_detail.WeatherListDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
public interface WeatherListDetailVmModule {

  @Binds
  @IntoMap
  @ViewModelKey(WeatherListDetailViewModel::class)
  fun bindListViewDetailViewModel(weatherListViewDetailModel: WeatherListDetailViewModel): ViewModel
}
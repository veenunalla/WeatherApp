package com.lowe.weatherapp.di

import android.app.Application
import com.lowe.core.network.NetworkModule
import com.lowe.weather.di.module.WeatherModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    LoweAppModule::class,
    NetworkModule::class,
    WeatherModule::class]
)
interface LoweComponent : AndroidInjector<LoweApplication> {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun withApplication(application: Application): Builder
    fun build(): LoweComponent
  }
}
package com.lowe.weatherapp.di

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class LoweApplication : DaggerApplication() {

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerLoweComponent.builder()
      .withApplication(this)
      .build()
  }

}
package com.lowe.weather.ui.city_search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lowe.core.network.Callback
import com.lowe.weather.di.model.WeatherItem
import com.lowe.weather.repository.WeatherRespository
import javax.inject.Inject

class CitySearchViewModel @Inject constructor(val weatherRespository: WeatherRespository) : ViewModel() {

  private val searchLiveData : MutableLiveData<Unit> = MutableLiveData()
  val mSearchLiveData: LiveData<Unit> = searchLiveData

  fun onCitySearchSelected(){
    searchLiveData.value = Unit
  }
}
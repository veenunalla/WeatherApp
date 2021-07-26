package com.lowe.weather.ui.weatherlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lowe.core.network.Callback
import com.lowe.weather.di.model.WeatherItem
import com.lowe.weather.repository.WeatherRespository
import javax.inject.Inject

class WeatherListViewModel @Inject constructor(val weatherRespository: WeatherRespository) : ViewModel() {

  private val listOfWeatherItem : MutableLiveData<List<WeatherItem>> = MutableLiveData()
  val mlistOfWeatherItem: LiveData<List<WeatherItem>> = listOfWeatherItem

  private val mShowProgress = MutableLiveData<Boolean>()
  val showProgress: LiveData<Boolean> = mShowProgress


  fun getWeatherReportForCity(city:String){
    mShowProgress.value = true
    weatherRespository.getWeatherForcast(city,object : Callback<List<WeatherItem>>{
      override fun onSuccess(data: List<WeatherItem>) {
        mShowProgress.value = false
        listOfWeatherItem.value = data
      }

      override fun onFailure(throwable: Throwable) {
        mShowProgress.value = false
        Log.e("error",throwable!!.localizedMessage)
      }
    })
  }

}
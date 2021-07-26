package com.lowe.weather.ui.weatherlist_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.lowe.core.base.BaseFragment
import com.lowe.core.base.provideViewModel
import com.lowe.weather.R
import com.lowe.weather.databinding.WeatherListDetailFragmentBinding
import com.lowe.weather.databinding.WeatherListFragmentBinding
import com.lowe.weather.ui.weatherlist.WeatherListFragmentArgs
import com.lowe.weather.ui.weatherlist.WeatherListViewModel

class WeatherListDetailFragment (override val layoutId: Int = R.layout.weather_list_detail_fragment) :
  BaseFragment<WeatherListDetailFragmentBinding, WeatherListDetailViewModel>(){

  private val args: WeatherListDetailFragmentArgs by navArgs()

  override fun obtainViewModel(): WeatherListDetailViewModel = provideViewModel(viewModelFactory)

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    binding.viewmodel = viewModel
    val item = args.weatherItem
    val temperature : Double = if(item.main?.temp != null) item.main.temp else 0.0
    val tempCelsius =((temperature - 32  ) *  5)/9
    val feelsLikeTemperature : Double = if(item.main?.feelsLike != null) item.main.feelsLike else 0.0
    val feelsLikeTemperatureCelsius =((feelsLikeTemperature - 32  ) *  5)/9
    val weatherStatus : String =if(item.weather?.first()?.main != null) item.weather.first().main!! else ""
    val weatherStatusDes : String =if(item.weather?.first()?.main != null) item.weather.first().description!! else ""

    binding.txtTemp.text = String.format("%.2f", tempCelsius)
    binding.txtTempFeelslike.text = "Feels Like${String.format("%.2f", feelsLikeTemperatureCelsius)}"
    binding.txtWeather.text = weatherStatus
    binding.txtWeatherDescription.text =weatherStatusDes
  }


}
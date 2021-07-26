package com.lowe.weather.ui.weatherlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lowe.core.base.BaseFragment
import com.lowe.core.base.provideViewModel
import com.lowe.weather.R
import com.lowe.weather.R.layout
import com.lowe.weather.databinding.WeatherListFragmentBinding
import com.lowe.weather.di.model.WeatherItem
import com.lowe.weather.ui.weatherlist.adapter.OnWeatherItemClickListener
import com.lowe.weather.ui.weatherlist.adapter.WeatherListAdapter

class WeatherListFragment(override val layoutId: Int = layout.weather_list_fragment) :
BaseFragment<WeatherListFragmentBinding, WeatherListViewModel>(),OnWeatherItemClickListener{

  private val args: WeatherListFragmentArgs by navArgs()
  override fun obtainViewModel(): WeatherListViewModel = provideViewModel(viewModelFactory)

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    binding.viewmodel = viewModel
    viewModel.mlistOfWeatherItem.observe(viewLifecycleOwner,{
      val adapter = WeatherListAdapter(it,this)
      binding.recyclerview.adapter = adapter
    })
    viewModel.showProgress.observe(viewLifecycleOwner,{ showProgress->
      if (showProgress){
        binding.progressBar.visibility = View.VISIBLE
      }else{
        binding.progressBar.visibility = View.GONE
      }
    })

    viewModel.getWeatherReportForCity(args.cityName)
  }

  override fun onResume() {
    super.onResume()
  }

  override fun onWeatherItemSelected(weatherItem: WeatherItem) {
    findNavController().navigate(WeatherListFragmentDirections.actionWeatherListToWeatherListDetail(args.cityName,weatherItem))
  }
}
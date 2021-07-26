package com.lowe.weather.ui.city_search

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.lowe.core.base.BaseFragment
import com.lowe.core.base.provideViewModel
import com.lowe.weather.R.layout
import com.lowe.weather.databinding.CitySearchFragmentBinding

class CitySearchFragment(override val layoutId: Int = layout.city_search_fragment) :
BaseFragment<CitySearchFragmentBinding, CitySearchViewModel>(){

  override fun obtainViewModel(): CitySearchViewModel = provideViewModel(viewModelFactory)

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    binding.viewmodel = viewModel

    binding.btnLookUp.setOnClickListener {
      findNavController().navigate(
        CitySearchFragmentDirections.showWeatherForCity(
          binding.edittextCityname.text.toString()
        )
      )
    }
  }

  override fun onResume() {
    super.onResume()
    activity?.title = "your title";

  }

}
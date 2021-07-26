package com.lowe.weather.ui.weatherlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lowe.weather.databinding.ItemCustomWeatherBinding
import com.lowe.weather.di.model.WeatherItemViewModel
import com.lowe.weather.di.model.WeatherItem
import com.lowe.weather.ui.weatherlist.WeatherListViewModel
import com.lowe.weather.ui.weatherlist.adapter.WeatherListAdapter.ViewHolder

class WeatherListAdapter(private val items: List<WeatherItem>,private val listener: OnWeatherItemClickListener) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCustomWeatherBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: ItemCustomWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherItem) {
            val temperature : Double = if(item.main?.temp != null) item.main.temp else 0.0
            val celsius =((temperature - 32  ) *  5)/9
            val weatherStatus : String =if(item.weather?.first()?.main != null) item.weather.first().main!! else ""
            val weatherItemViewModel = WeatherItemViewModel(weatherStatus,String.format("%.2f", celsius))
            binding.item = weatherItemViewModel
            binding.rootView.setOnClickListener {
                listener.onWeatherItemSelected(item)
            }
            binding.executePendingBindings()
        }
    }
}

interface OnWeatherItemClickListener{
    fun onWeatherItemSelected(weatherItem: WeatherItem)
}
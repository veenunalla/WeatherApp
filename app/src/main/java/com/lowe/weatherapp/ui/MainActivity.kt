package com.lowe.weatherapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.lowe.weatherapp.R
import com.lowe.weatherapp.R.id
import com.lowe.weatherapp.R.layout
import kotlinx.android.synthetic.main.activity_main.toolbar
import java.util.Locale

class MainActivity : AppCompatActivity() {
  private lateinit var controller: NavController // don't forget to initialize

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    controller = Navigation.findNavController(this, R.id.nav_host_fragment)
    controller.addOnDestinationChangedListener(listener)
    setSupportActionBar(toolbar);

    // add back arrow to toolbar
      supportActionBar?.setDisplayHomeAsUpEnabled(true);
      supportActionBar?.setDisplayShowHomeEnabled(true);

    toolbar.setNavigationOnClickListener {
      if (controller.currentDestination!!.id != R.id.citySearchFragment){
        controller.popBackStack()
      }
    }
  }
  private val listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
    if (destination.id == R.id.citySearchFragment){
      toolbar.visibility = View.GONE
    }else{
      toolbar.visibility = View.VISIBLE
      toolbar.title = arguments?.getString("cityName")?.toUpperCase(Locale.getDefault())
    }
    // react on change
    // you can check destination.id or destination.label and act based on that
  }

}
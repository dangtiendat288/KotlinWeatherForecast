package com.example.kotlinweatherforecast.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinweatherforecast.Adapter.WeatherAdapter
import com.example.kotlinweatherforecast.R
import com.example.kotlinweatherforecast.ViewModel.WeatherViewModel
import com.example.kotlinweatherforecast.databinding.ActivityForecastBinding
import kotlinx.android.synthetic.main.activity_forecast.*

class ForecastActivity : AppCompatActivity() {
    private lateinit var mWeatherViewModel: WeatherViewModel
    lateinit var mBinding: ActivityForecastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityForecastBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mWeatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        val city = intent.getStringExtra("city")
        if (city != null) {
            tvCity.text = city
            mWeatherViewModel.fetch7DaysWeather(city)
        }

        rv7Days.hasFixedSize()
        val adapter = WeatherAdapter(this)
        rv7Days.adapter = adapter

        mWeatherViewModel.get7DaysWeather()
            .observe(this, Observer {data->
                Log.d("ABC",data.toString())
                val listData = data.list
                adapter.submitList(listData)
            })


    }
}
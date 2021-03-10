package com.example.kotlinweatherforecast

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kotlinweatherforecast.Activity.ForecastActivity
import com.example.kotlinweatherforecast.ViewModel.WeatherViewModel
import com.example.kotlinweatherforecast.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mWeatherViewModel: WeatherViewModel
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mWeatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        edtCity.setText("Saigon")
        mWeatherViewModel.fetchCurrentWeather("Saigon")

        tvForecast.setOnClickListener {
            intent = Intent(this@MainActivity,ForecastActivity::class.java)
            val city = edtCity.text.toString().trim()
            intent.putExtra("city",city)
            startActivity(intent)
        }

        tvSearch.setOnClickListener {
            val city = edtCity.text.toString().trim()
            if(city.isEmpty()){
                Toast.makeText(this@MainActivity,"Nhập đi!",Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

//            edtCity.text.clear()
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            llBackground.setBackgroundColor(color)
            val inputManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            inputManager.hideSoftInputFromWindow(
                currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
            mWeatherViewModel.fetchCurrentWeather(city)
        }



        mWeatherViewModel.getCurrentWeather().observe(this, Observer { data ->
//           Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT)
            Log.d("ABC", data.toString())

            //City name
            val name = data.name
            tvCity.text = name

            //Time
            val day = data.dt
            val date = Date(day * 1000L)
            val simpleDateFormat = SimpleDateFormat("EEEE yyyy-MM-dd HH-mm-ss")
            val Day = simpleDateFormat.format(date)
            Log.d("ABC", Day)

            //icon&main
            val currentWeather = data.weather[0]
            val status = currentWeather.main
            tvStatus.text = status
            val icon = currentWeather.icon
//            URL is http://openweathermap.org/img/wn/10d@2x.png
            Glide.with(this)
                .load("http://openweathermap.org/img/wn/$icon@2x.png")
                .centerCrop()
//                .placeholder()
                .into(ivStatus)

            //main
            val main = data.main!!
            val nhietdo = main.temp.toInt()
            tvTemp.text = "$nhietdo°"

            val tempMin = main.temp_min.toInt()
            val tempMax = main.temp_max.toInt()
            tvTempRangeNbr.text ="$tempMin-$tempMax°C"

            val doam = main.humidity.toInt()
            tvHumidityNbr.text = "$doam%"
            //wind
            val speed = data.wind!!.speed
            tvWindNbr.text = "$speed" + "m/s"
            //cloud
            val clouds = data.clouds!!.all.toInt()
            tvCloudsNbr.text = "$clouds%"
            //system
            val sys = data.sys!!
            val country = sys.country

        })
    }
}
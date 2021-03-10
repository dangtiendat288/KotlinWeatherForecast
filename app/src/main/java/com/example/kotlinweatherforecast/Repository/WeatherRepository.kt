package com.example.kotlinweatherforecast.Repository

import com.example.kotlinweatherforecast.API.RetrofitInit
import com.example.kotlinweatherforecast.Model.ApiResponse
import com.example.kotlinweatherforecast.Model.ApiResponse1
import io.reactivex.rxjava3.core.Maybe


object WeatherRepository {
    fun fetchCurrentWeatherData(string: String): Maybe<ApiResponse> {
        return RetrofitInit.mApiResquest.fetchCurrentWeatherData(string)
    }

    fun fetch7DaysWeatherData(string: String): Maybe<ApiResponse1> {
        return RetrofitInit.mApiResquest.fetch7DaysWeatherData(string)
    }

}


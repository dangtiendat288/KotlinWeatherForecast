package com.example.kotlinweatherforecast.API

import com.example.kotlinweatherforecast.Model.ApiResponse
import com.example.kotlinweatherforecast.Model.ApiResponse1
import io.reactivex.rxjava3.core.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("weather?units=metric&appid=${RetrofitInit.APIKEY}")
    fun fetchCurrentWeatherData(@Query("q")string: String): Maybe<ApiResponse>

    @GET("forecast/daily?units=metric&cnt=10&appid=${RetrofitInit.VIPAPIKEY}")
    fun fetch7DaysWeatherData(@Query("q") string: String): Maybe<ApiResponse1>
}
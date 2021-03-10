package com.example.kotlinweatherforecast.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinweatherforecast.Model.ApiResponse
import com.example.kotlinweatherforecast.Model.ApiResponse1
import com.example.kotlinweatherforecast.Repository.WeatherRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val mCurrentWeather = MutableLiveData<ApiResponse>()
    private val m7DaysWeather = MutableLiveData<ApiResponse1>()

    fun fetchCurrentWeather(string: String) {
        WeatherRepository.fetchCurrentWeatherData(string)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<ApiResponse> {
                override fun onSubscribe(d: @NonNull Disposable?) {}

                override fun onSuccess(apiResponse: @NonNull ApiResponse?) {
                    mCurrentWeather.value = apiResponse
                }

                override fun onError(e: @NonNull Throwable?) {}

                override fun onComplete() {}
            })
    }

    fun getCurrentWeather(): LiveData<ApiResponse> {
        return mCurrentWeather
    }

    fun fetch7DaysWeather(string: String) {
        WeatherRepository.fetch7DaysWeatherData(string)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<ApiResponse1> {
                override fun onSubscribe(d: @NonNull Disposable?) {}

                override fun onSuccess(apiResponse1: @NonNull ApiResponse1?) {
                    m7DaysWeather.value = apiResponse1
                }

                override fun onError(e: @NonNull Throwable?) {}

                override fun onComplete() {}
            })
    }

    fun get7DaysWeather(): LiveData<ApiResponse1> {
        return m7DaysWeather
    }
}
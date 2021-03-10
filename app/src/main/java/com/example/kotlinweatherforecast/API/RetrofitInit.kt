package com.example.kotlinweatherforecast.API


import com.example.kotlinweatherforecast.Model.ApiResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInit {
    const val APIKEY = "97bdfa81b1dd9e955d91bf0a5d196a20"
    const val VIPAPIKEY = "53fbf527d52d4d773e828243b90c1f8e"

    private const val BASEURL = "https://api.openweathermap.org/data/2.5/"
    val gson: Gson = GsonBuilder().setLenient().create()
    val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .protocols(listOf(Protocol.HTTP_1_1))
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    val mRetrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()


    val mApiResquest: ApiRequest =
        mRetrofit.create(ApiRequest::class.java)

}
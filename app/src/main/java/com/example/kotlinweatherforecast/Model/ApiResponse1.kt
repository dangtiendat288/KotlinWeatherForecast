package com.example.kotlinweatherforecast.Model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class ApiResponse1 {
    @SerializedName("city")
    @Expose
    private var city: City? = null

    @SerializedName("cod")
    @Expose
    private var cod: String? = null

    @SerializedName("message")
    @Expose
    private var message: Double? = null

    @SerializedName("cnt")
    @Expose
    private var cnt: Int? = null

    @SerializedName("list")
    @Expose
//    private var list:ArrayList<List> = arrayListOf()
    var list = ArrayList<List>()


    override fun toString(): String {
        return "ApiResponse1(city=$city, cod=$cod, message=$message, cnt=$cnt, list=$list)"
    }


}

class City {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("coord")
    @Expose
    var coord: Coord? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("population")
    @Expose
    var population: Int? = null

    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null
    override fun toString(): String {
        return "City(id=$id, name=$name, coord=$coord, country=$country, population=$population, timezone=$timezone)"
    }


}

class Coord {
    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    override fun toString(): String {
        return "Coord(lon=$lon, lat=$lat)"
    }

}

class FeelsLike {
    @SerializedName("day")
    @Expose
    var day: Double? = null

    @SerializedName("night")
    @Expose
    var night: Double? = null

    @SerializedName("eve")
    @Expose
    var eve: Double? = null

    @SerializedName("morn")
    @Expose
    var morn: Double? = null
    override fun toString(): String {
        return "FeelsLike(day=$day, night=$night, eve=$eve, morn=$morn)"
    }

}

class List {
    @SerializedName("dt")
    @Expose
    var dt: Long? = null

    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null

    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null

    @SerializedName("temp")
    @Expose
    var temp: Temp? = null

    @SerializedName("feels_like")
    @Expose
    var feelsLike: FeelsLike? = null

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null

    @SerializedName("weather")
    @Expose
    var weather: kotlin.collections.List<Weather>? = null

    @SerializedName("speed")
    @Expose
    var speed: Double? = null

    @SerializedName("deg")
    @Expose
    var deg: Int? = null

    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null

    @SerializedName("pop")
    @Expose
    var pop: Double? = null

    @SerializedName("rain")
    @Expose
    var rain: Double? = null
    override fun toString(): String {
        return "List(dt=$dt, sunrise=$sunrise, sunset=$sunset, temp=$temp, feelsLike=$feelsLike, pressure=$pressure, humidity=$humidity, weather=$weather, speed=$speed, deg=$deg, clouds=$clouds, pop=$pop, rain=$rain)"
    }


}

class Temp {
    @SerializedName("day")
    @Expose
    var day: Double? = null

    @SerializedName("min")
    @Expose
    var min: Double? = null

    @SerializedName("max")
    @Expose
    var max: Double? = null

    @SerializedName("night")
    @Expose
    var night: Double? = null

    @SerializedName("eve")
    @Expose
    var eve: Double? = null

    @SerializedName("morn")
    @Expose
    var morn: Double? = null
    override fun toString(): String {
        return "Temp(day=$day, min=$min, max=$max, night=$night, eve=$eve, morn=$morn)"
    }


}

class Weather {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("main")
    @Expose
    var main: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("icon")
    @Expose
    var icon: String? = null
    override fun toString(): String {
        return "Weather(id=$id, main=$main, description=$description, icon=$icon)"
    }


}
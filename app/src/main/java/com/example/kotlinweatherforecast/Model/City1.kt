package com.example.kotlinweatherforecast.Model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class City1 {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("state")
    @Expose
    var state: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("coord")
    @Expose
    var coord: Coord? = null

}
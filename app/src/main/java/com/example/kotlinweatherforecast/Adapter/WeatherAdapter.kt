package com.example.kotlinweatherforecast.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinweatherforecast.Model.List
import com.example.kotlinweatherforecast.R
import java.text.SimpleDateFormat
import java.util.*


class WeatherAdapter(val context: Context) : ListAdapter<List,WeatherAdapter.WeatherViewHolder>(DIFF_CALLBACK) {

    object DIFF_CALLBACK:DiffUtil.ItemCallback<List>() {
        override fun areItemsTheSame(oldItem: List, newItem: List): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: List, newItem: List): Boolean {
            return true
        }
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate:TextView = itemView.findViewById(R.id.tvDate)
        val tvStatus:TextView = itemView.findViewById(R.id.tvStatus)
        val ivStatus:ImageView = itemView.findViewById(R.id.ivStatus)
        val tvTempRange:TextView = itemView.findViewById(R.id.tvTempRange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item,parent,false)
        return WeatherViewHolder(v)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = getItem(position)

        //bind date
        val date = Date(currentItem.dt!!*1000L)
        val simpleDateFormat = SimpleDateFormat("EEEE yyyy-MM-dd")
        val Day = simpleDateFormat.format(date)
        holder.tvDate.text = Day

        //bind status
        holder.tvStatus.text = currentItem.weather!![0].main

        //bind icon
        Glide.with(context)
            .load("http://openweathermap.org/img/wn/${currentItem.weather!![0].icon}@2x.png")
            .centerCrop()
//                .placeholder()
            .into(holder.ivStatus)

        //bind temp range
        holder.tvTempRange.text = "${currentItem.temp!!.min!!.toInt()}-${currentItem.temp!!.max!!.toInt()}°"
    }
}
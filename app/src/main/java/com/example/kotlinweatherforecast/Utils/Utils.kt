package com.example.kotlinweatherforecast.Utils

import android.content.Context
import java.io.IOException
import java.io.InputStream

class Utils {
    companion object{
        fun getJsonFromAssets(context: Context, fileName: String?): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName!!).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}
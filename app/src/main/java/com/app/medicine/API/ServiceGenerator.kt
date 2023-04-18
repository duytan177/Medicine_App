package com.app.medicine.API

import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.StringReader
import java.util.concurrent.TimeUnit


object ServiceGenerator  {
    private val client = OkHttpClient.Builder().build()

//    private const val URL = "http://192.168.1.7:8080/"

    // Địa chỉ của Nam
    private const val URL = "http://192.168.56.1:8080/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }

}
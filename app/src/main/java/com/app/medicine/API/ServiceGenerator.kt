package com.app.medicine.API

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceGenerator  {
    private val client = OkHttpClient.Builder().build()

    // Địa chỉ của Nam

    private const val URL = "http://192.168.1.109:8080/"
    fun getInstance(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

}
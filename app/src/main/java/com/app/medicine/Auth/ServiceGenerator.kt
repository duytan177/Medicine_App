package com.app.medicine

import android.app.Application
import android.app.Service
import com.app.medicine.Auth.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceGenerator  {
    private val client = OkHttpClient.Builder().build()
    private const val URL = "http://192.168.1.5:8080/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

}
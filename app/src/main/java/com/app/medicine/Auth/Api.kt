package com.app.medicine.Auth


import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST


interface Api {


    @POST("/projectdemo/api/login")
    fun login(@Body userRequest:UserRequest) : Call<UserModel>

}
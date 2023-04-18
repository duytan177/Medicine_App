package com.app.medicine.API


import com.app.medicine.Model.CityResponse
import com.app.medicine.Model.RegisterRequest
import com.app.medicine.Model.UserModel
import com.app.medicine.Model.UserRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.POST
import java.util.Objects


interface Api {

    @POST("/projectdemo/api/login")
    fun login(@Body userRequest: UserRequest) : Call<UserModel>


    @GET("projectdemo/register")
    fun getCities(): Call<MutableList<CityResponse>>


    @POST("/projectdemo/api/register")
    fun register(@Body registerRequest: RegisterRequest) : Call<UserModel>
}
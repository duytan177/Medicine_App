package com.app.medicine.API


import com.app.medicine.Controller.CityResponse
import com.app.medicine.Controller.RegisterRequest
import com.app.medicine.Model.UserModel
import com.app.medicine.Controller.UserRequest
import com.app.medicine.Model.SponsorshipModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.POST


interface Api {

    @POST("/projectdemo/api/login")
    fun login(@Body userRequest: UserRequest) : Call<UserModel>

    @GET("projectdemo/register")
    fun getCities(): Call<MutableList<CityResponse>>


    @POST("/projectdemo/api/register")
    fun register(@Body registerRequest: RegisterRequest) : Call<UserModel>

    @GET("projectdemo/api")
    fun getSponsorship() : Call<MutableList<SponsorshipModel>>
}
package com.app.medicine.API


import com.app.medicine.Controller.*
import com.app.medicine.Model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET

import retrofit2.http.POST
import retrofit2.http.Path


interface Api {

    @POST("/projectdemo/api/login")
    fun login(@Body userRequest: UserRequest) : Call<UserModel>

    @GET("projectdemo/register")
    fun getCities(): Call<MutableList<CityResponse>>

    @POST("/projectdemo/api/register")
    fun register(@Body registerRequest: RegisterRequest,) : Call<UserModel>

    @GET("projectdemo/api/user/sponsorship")
    fun getSponsorship() : Call<MutableList<SponsorshipModel>>

    @GET("projectdemo/admin/user")
    fun getAllUsers() : Call<MutableList<UsersModel>>

    @GET("projectdemo/user/profile")
    fun getAllProfiles() : Call<MutableList<ProfileModel>>

    @POST("projectdemo/user/profile")
    fun getUploadImage(@Body uploadProfile: UploadProfileRequest) : Call<MutableList<ProfileUploadModel>>

    @DELETE("projectdemo/admin/delete")
    fun deleteUser(@Path("id") userId :String): Call<MutableList<UsersModel>>
}
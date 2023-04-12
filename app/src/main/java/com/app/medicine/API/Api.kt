package com.app.medicine.API


import com.app.medicine.Model.UserModel
import com.app.medicine.Auth.UserRequest
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST


interface Api {

    @POST("/projectdemo/api/login")
    fun login(@Body userRequest: UserRequest) : Call<UserModel>

}
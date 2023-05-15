package com.app.medicine.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModel{
    @SerializedName("data")
    @Expose
    var data: User?= null

    class User{
        @SerializedName("id") //---> Ví dụ, trường studentId trong được đại diện là ID trong JSON.
        @Expose
        var id:String ?= null

        @SerializedName("email")
        @Expose
        var email:String ?= null


        @SerializedName("name")
        @Expose
        var name:String ?= null

        @SerializedName("role") //---> Ví dụ, trường studentId trong được đại diện là ID trong JSON.
        @Expose
        var role:String ?= null

        @SerializedName("token")
        @Expose
        var token:String ?= null
    }
}

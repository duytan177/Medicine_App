package com.app.medicine.Controller

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest  {
    @SerializedName("email")
    @Expose
    var email:String ?= null
    @SerializedName("passwordd")
    @Expose
    var password:String ?= null
}
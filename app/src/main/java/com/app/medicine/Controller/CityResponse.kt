package com.app.medicine.Controller

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityResponse (
        var id:String ?= null,
        var name:String ?= null,
//        var department:String ?= null,
//        var region:String ?= null,
//        var pop:String ?= null
)
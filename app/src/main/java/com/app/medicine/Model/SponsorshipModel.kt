package com.app.medicine.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SponsorshipModel(
        var name: String ?= null,
        var date: String ?= null,
        var active: Int ?= null
)
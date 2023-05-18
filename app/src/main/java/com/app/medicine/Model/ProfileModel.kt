package com.app.medicine.Model

data class ProfileModel(
    var id: Int ?= null,
    var num_affair: String ?= null,
    var default: String ?= null,
    var service_price: String ?= null,
    var request_authority: String ?= null,
    var type_of_service: String ?= null,
    var name: String ?= null,
    var created_at: String ?= null,
    var updated_at: String ?= null
)
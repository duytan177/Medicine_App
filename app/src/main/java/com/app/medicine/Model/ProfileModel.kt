package com.app.medicine.Model

data class ProfileModel(
    val created_at: String ?= null,
    val default: String ?= null,
    val id: Int ?= null,
    val name: String ?= null,
    val num_affair: String ?= null,
    val request_authority: String ?= null,
    val service_price: String ?= null,
    val type_of_service: String ?= null,
    val updated_at: String ?= null
)
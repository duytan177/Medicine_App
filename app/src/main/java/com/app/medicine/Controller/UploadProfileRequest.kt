package com.app.medicine.Controller

data class UploadProfileRequest(
    var date: String ?= null,
    var serviceDate: String ?= null,
    var numberAffair: String ?= null,
    var servicePrice: String ?= null,
    var default: String ?= null,
    var _token: String ?= null,
    var authority: String ?= null,
    var service: String ?= null,
    var imageUpload: String ?= null
)
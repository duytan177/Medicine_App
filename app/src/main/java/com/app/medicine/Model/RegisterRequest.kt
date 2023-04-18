package com.app.medicine.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterRequest {

    @SerializedName("status")
    @Expose
    var status:String ?= null

    @SerializedName("firstname")
    @Expose
    var firstname:String ?= null

    @SerializedName("lastname")
    @Expose
    var lastname:String ?= null

    @SerializedName("email")
    @Expose
    var email:String ?= null

    @SerializedName("password")
    @Expose
    var password:String ?= null

    @SerializedName("password_confirmation")
    @Expose
    var password_comfirmation:String ?= null

    @SerializedName("dateofbirth")
    @Expose
    var dateofbirth:String ?= null

    @SerializedName("address1")
    @Expose
    var address1:String ?= null

    @SerializedName("codepostal")
    @Expose
    var codepostal:String ?= null

    @SerializedName("address2")
    @Expose
    var address2:String ?= null

    @SerializedName("city")
    @Expose
    var city:String ?= null

    @SerializedName("siret")
    @Expose
    var siret:String ?= null

    @SerializedName("VAT")
    @Expose
    var VAT:String ?= null

    @SerializedName("IBAN")
    @Expose
    var IBAN:String ?= null

    @SerializedName("swift")
    @Expose
    var swift:String ?= null

    @SerializedName("sponsor")
    @Expose
    var sponsor:String ?= null

    @SerializedName("numberSSRS")
    @Expose
    var numberSSRS:String ?= null

    @SerializedName("default")
    @Expose
    var default:String ?= null

    @SerializedName("provider")
    @Expose
    var provider:String ?= null

    @SerializedName("dissertation")
    @Expose
    var dissertation:String ?= null

}
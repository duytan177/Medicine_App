package com.app.medicine.Model

data class UsersModel(
    var id: Int ?= null,
    var status: String ?= null,
    var name: String ?= null,
    var email: String ?= null,
    var role: Int ?= null,
    var dateofbirth: String ?= null,
    var address1: String ?= null,
    var address2: String ?= null,
    var codepostal: String ?= null,
    var city_id: Int ?= null,
    var siret: String ?= null,
    var vat: String ?= null,
    var iban: String ?= null,
    var swift: String ?= null,
    var sponsor: String ?= null,
    var percentage: String ?= null,
    var numberSSRS: String ?= null,
    var default: String ?= null,
    var provider: String ?= null,
    var dissertation: String ?= null,
    var active: Int ?= null,
    var email_verified_at: String ?= null,
    var password: String ?= null,
    var remember_token: String ?= null,
    var api_token: String ?= null,
    var created_at: String ?= null,
    var updated_at: String ?= null
)
//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName
//
//class UsersModel{
//    @SerializedName("data")
//    @Expose
//    var data: Users?= null
//
//    class Users{
//        @SerializedName("id")
//        @Expose
//        var id:String ?= null
//
//        @SerializedName("status")
//        @Expose
//        var status: String ?= null
//
//        @SerializedName("name")
//        @Expose
//        var name: String ?= null
//
//        @SerializedName("email")
//        @Expose
//        var email: String ?= null
//
//        @SerializedName("role")
//        @Expose
//        var role: Int ?= null
//
//        @SerializedName("dateofbirth")
//        @Expose
//        var dateofbirth: String ?= null
//
//        @SerializedName("address1")
//        @Expose
//        var address1: String ?= null
//
//        @SerializedName("address2")
//        @Expose
//        var address2: String ?= null
//
//        @SerializedName("codepostal")
//        @Expose
//        var codepostal: String ?= null
//
//        @SerializedName("city_id")
//        @Expose
//        var city_id: String ?= null
//
//        @SerializedName("siret")
//        @Expose
//        var siret: String ?= null
//
//        @SerializedName("vat")
//        @Expose
//        var vat: String ?= null
//        @SerializedName("iban")
//        @Expose
//        var iban: String ?= null
//
//        @SerializedName("swift")
//        @Expose
//        var swift: String ?= null
//
//        @SerializedName("sponsor")
//        @Expose
//        var sponsor: String ?= null
//
//        @SerializedName("percentage")
//        @Expose
//        var percentage: String ?= null
//
//        @SerializedName("numberSSRS")
//        @Expose
//        var numberSSRS: String ?= null
//
//        @SerializedName("default")
//        @Expose
//        var default: String ?= null
//
//        @SerializedName("provider")
//        @Expose
//        var provider: String ?= null
//
//        @SerializedName("dissertation")
//        @Expose
//        var dissertation: String ?= null
//
//        @SerializedName("active")
//        @Expose
//        var active: String ?= null
//
//        @SerializedName("email_verified_at")
//        @Expose
//        var email_verified_at: String ?= null
//
//        @SerializedName("password")
//        @Expose
//        var password: String ?= null
//
//        @SerializedName("api_token")
//        @Expose
//        var api_token: String ?= null
//
//        @SerializedName("remember_token")
//        @Expose
//        var remember_token: String ?= null
//
//        @SerializedName("created_at")
//        @Expose
//        var created_at: String ?= null
//
//        @SerializedName("updated_at")
//        @Expose
//        var updated_at: String ?= null
//    }
//}
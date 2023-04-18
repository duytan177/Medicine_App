package com.app.medicine.Auth

import android.app.DatePickerDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
// import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Controller.CityResponse
import com.app.medicine.Controller.RegisterRequest
import com.app.medicine.Model.UserModel
import com.app.medicine.R

import com.google.gson.stream.JsonReader
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.StringReader
import java.text.SimpleDateFormat
import java.util.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var api: Api
    private lateinit var sf : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()

        api = ServiceGenerator.getInstance().create(Api::class.java)

        getCity()

        status.setOnCheckedChangeListener() { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            val value = radioButton.text.toString()
            Log.i("HIHIHIHIHi", "Value: " + value)
        }

        /* Button Create Account */
        btnCreate.setOnClickListener() {
            // Get value on checkbox when we onlick button create
            val checkedRadioButtonId = status.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                val radioButton = findViewById<RadioButton>(checkedRadioButtonId)
                val status = radioButton.text.toString()
                Log.i("Nút Create", "Value: " + status)
            }
        }

        // Date of Birth
        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener() { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }

        btnSelectDate.setOnClickListener() {
            DatePickerDialog(
                this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        btnCreate.setOnClickListener() {
            status.setOnCheckedChangeListener() { group, checkedId ->
                val radioButton = findViewById<RadioButton>(checkedId)
                val valueStatus = radioButton.text.toString()
            }
            val request = RegisterRequest()
            val id: Int = status.checkedRadioButtonId
            request.status = findViewById<RadioButton>(id).text.toString()
            request.firstname = edtFirstName.text.toString()
            request.lastname = edtLastName.text.toString()
            request.email = edtEmail.text.toString()
            request.password = edtPassword.text.toString()
            request.password_comfirmation = edtConfirmPassword.text.toString()
            request.dateofbirth = edtDate.text.toString()
            request.address1 = edtAddress1.text.toString()
            request.address2 = edtAddress2.text.toString()
            request.codepostal = edtCodePostal.text.toString()
            request.city = (edtCity.selectedItemId+1).toString()
            request.siret = edtSiret.text.toString()
            request.VAT = edtNumVAT.text.toString()
            request.IBAN = edtIBAN.text.toString()
            request.swift = edtBIC.text.toString()
            request.sponsor = edtSponsorCode.text.toString()
            request.numberSSRS = edtSSRS.text.toString()
            request.default = edtDefault.text.toString()
            request.provider = edtProviderCategory.text.toString()
            request.dissertation = edtDissertationCurrency.text.toString()
            Log.e("success",  request.status.toString())
            Log.e("success",  request.firstname.toString())
            Log.e("success",  request.lastname.toString())
            Log.e("success",  request.email.toString())
            Log.e("success",  request.password.toString())
            Log.e("success",  request.password_comfirmation.toString())
            Log.e("success",  request.dateofbirth.toString())
            Log.e("success",  request.address1.toString())
            Log.e("success",  request.address2.toString())
            Log.e("success",  request.codepostal.toString())
            Log.e("success",  request.city.toString())
            Log.e("success",  request.siret.toString())
            Log.e("success",  request.VAT.toString())
            Log.e("success",  request.IBAN.toString())
            Log.e("success",  request.swift.toString())
            Log.e("success",  request.sponsor.toString())
            Log.e("success",  request.numberSSRS.toString())
            Log.e("success",  request.default.toString())
            Log.e("success",  request.provider.toString())
            Log.e("success",  request.dissertation.toString())


            val call = api.register(request)
            Log.e("json",request.toString())
            call.enqueue(object : Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    val code = response.code().toString()
                    Log.e("success",response.toString())


                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                   Log.e("error",t.message.toString())
                    t.printStackTrace()
                }
            })
        }
    }

    override fun onPause() {
        super.onPause()

        status.setOnCheckedChangeListener() { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            val valueStatus = radioButton.text.toString()
        }
        val request = RegisterRequest()
        val id: Int = status.checkedRadioButtonId
        var status = findViewById<RadioButton>(id).text.toString()
        var firstname = edtFirstName.text.toString()
        var lastname = edtLastName.text.toString()
        var email = edtEmail.text.toString()
        var password = edtPassword.text.toString()
        var password_comfirmation = edtConfirmPassword.text.toString()
        var dataofbirth = edtDate.text.toString()
        var address1 = edtAddress1.text.toString()
        var address2 = edtAddress2.text.toString()
        var codepostal = edtCodePostal.text.toString()
        var city = (edtCity.selectedItemId+1).toString()
        var siret = edtSiret.text.toString()
        var VAT = edtNumVAT.text.toString()
        var IBAN = edtIBAN.text.toString()
        var swift = edtBIC.text.toString()
        var sponsor = edtSponsorCode.text.toString()
        var numberSSRS = edtSSRS.text.toString()
        var default = edtDefault.text.toString()
        var provider = edtProviderCategory.text.toString()
        var dissertation = edtDissertationCurrency.text.toString()
        editor.apply() {
            putString("status", status)
            putString("firstname", firstname)
            putString("lastname", lastname)
            putString("email", email)
            putString("password", password)
            putString("password_comfirmation", password_comfirmation)
            putString("dateofbirth", dataofbirth)
            putString("address1", address1)
            putString("address2", address2)
            putString("codepostal", codepostal)
            putInt("city", city.toInt())
            putString("siret", siret)
            putString("VAT", VAT)
            putString("IBAN", IBAN)
            putString("swift", swift)
            putString("sponsor", sponsor)
            putString("numberSSRS", numberSSRS)
            putString("default", default)
            putString("provider", provider)
            putString("dissertation", dissertation)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        var status = sf.getString("status",null);

        edtFirstName.setText(sf.getString("firstname", null))
        edtLastName.setText(sf.getString("lastname", null))
        edtEmail.setText(sf.getString("email", null))
        edtPassword.setText(sf.getString("password", null))
        edtConfirmPassword.setText(sf.getString("password_comfirmation", null))
        edtDate.setText(sf.getString("dateofbirth", null))
        edtAddress1.setText(sf.getString("address1", null))
        edtAddress2.setText(sf.getString("address2", null))
        edtCodePostal.setText(sf.getString("codepostal", null))
//        edtCity.setSelection(sf.getInt("city", 0))
        edtSiret.setText(sf.getString("siret", null))
        edtNumVAT.setText(sf.getString("VAT", null))
        edtIBAN.setText(sf.getString("IBAN", null))
        edtBIC.setText(sf.getString("swift", null))
        edtSponsorCode.setText(sf.getString("sponsor", null))
        edtSSRS.setText(sf.getString("numberSSRS", null))
        edtDefault.setText(sf.getString("default", null))
        edtProviderCategory.setText(sf.getString("provider", null))
        edtDissertationCurrency.setText(sf.getString("dissertation", null))
    }
    private fun getCity() {
       val callData  = api.getCities()
        callData.enqueue(object : Callback<MutableList<CityResponse>>{
            override fun onResponse(
                call: Call<MutableList<CityResponse>>,
                response: Response<MutableList<CityResponse>>
            ) {
                Log.e("success",response.body().toString())
                val cities = response.body()
                val items : MutableList<String> = mutableListOf()
                for (city in cities!!){
                    items.add(city.name.toString())
                }
                val adapter = ArrayAdapter(this@RegisterActivity, android.R.layout.simple_spinner_dropdown_item, items)
                edtCity.adapter = adapter
            }

            override fun onFailure(call: Call<MutableList<CityResponse>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }
        })

    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        edtDate.setText(sdf.format(myCalendar.time))

    }


}





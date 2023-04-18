package com.app.medicine.Auth

import android.app.DatePickerDialog
//import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Controller.CityResponse
import com.app.medicine.Controller.RegisterRequest
import com.app.medicine.Model.UserModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import retrofit2.Callback


class RegisterActivity : AppCompatActivity() {

    private lateinit var api: Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        api = ServiceGenerator.getInstance().create(Api::class.java)
        getCity()
        // Radio Button
//        mr.setOnClickListener() {
//            checkbox_Mr.isChecked = true
//            checkbox_Mrs.isChecked = false
//            checkbox_Dr.isChecked = false
//            checkbox_Me.isChecked = false
//        }
//        checkbox_Mrs.setOnClickListener() {
//            checkbox_Mr.isChecked = false
//            checkbox_Mrs.isChecked = true
//            checkbox_Dr.isChecked = false
//            checkbox_Me.isChecked = false
//        }
//        checkbox_Dr.setOnClickListener() {
//            checkbox_Mr.isChecked = false
//            checkbox_Mrs.isChecked = false
//            checkbox_Dr.isChecked = true
//            checkbox_Me.isChecked = false
//        }
//        checkbox_Me.setOnClickListener() {
//            checkbox_Mr.isChecked = false
//            checkbox_Mrs.isChecked = false
//            checkbox_Dr.isChecked = false
//            checkbox_Me.isChecked = true
//        }
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
            request.dataofbirth = edtDate.text.toString()
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
            Log.e("success", request.password_comfirmation.toString())
            Log.e("success",  request.dataofbirth.toString())
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
            call.enqueue(object : Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    val code = response.code().toString()
                    Log.e("success",response.body().toString())
                    val cities = response.body()


                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                   Log.e("error",t.printStackTrace().toString())
                }
            })
        }
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
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        edtDate.setText(sdf.format(myCalendar.time))

    }
}





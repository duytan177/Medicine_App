package com.app.medicine.views.user

import android.app.DatePickerDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Controller.CityResponse
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AccountFragment : Fragment() {
    private lateinit var api: Api
    private lateinit var sf : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        api = ServiceGenerator.getInstance().create(Api::class.java)
        getCity()

        view.statusUpdate.setOnCheckedChangeListener() { group, checkedId ->
            val radioButton = view.findViewById<RadioButton>(checkedId)
            val value = radioButton.text.toString()
            Log.i("HIHIHIHIHi", "Value: " + value)
        }

        // Date of Birth
        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener() { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }


        view.btnSelectDateUpdate.setOnClickListener() {
            DatePickerDialog(
                requireContext(), datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        return view
    }
    public fun getCity() {
        val callData  = api.getCities()
        callData.enqueue(object : Callback<MutableList<CityResponse>> {
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
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)
                view?.edtCity?.adapter ?: adapter
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
package com.app.medicine.Auth

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Radio Button
        checkbox_Mr.setOnClickListener() {
            checkbox_Mr.isChecked = true
            checkbox_Mrs.isChecked = false
            checkbox_Dr.isChecked = false
            checkbox_Me.isChecked = false
        }
        checkbox_Mrs.setOnClickListener() {
            checkbox_Mr.isChecked = false
            checkbox_Mrs.isChecked = true
            checkbox_Dr.isChecked = false
            checkbox_Me.isChecked = false
        }
        checkbox_Dr.setOnClickListener() {
            checkbox_Mr.isChecked = false
            checkbox_Mrs.isChecked = false
            checkbox_Dr.isChecked = true
            checkbox_Me.isChecked = false
        }
        checkbox_Me.setOnClickListener() {
            checkbox_Mr.isChecked = false
            checkbox_Mrs.isChecked = false
            checkbox_Dr.isChecked = false
            checkbox_Me.isChecked = true
        }
        radioGroup.setOnCheckedChangeListener() { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            val value = radioButton.text.toString()
//            Log.i("HIHIHIHIHi", "Value: " + value)
        }

        /* Button Create Account */
        btnCreate.setOnClickListener() {
            // Get value on checkbox when we onlick button create
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            if(checkedRadioButtonId != -1) {
                val radioButton = findViewById<RadioButton>(checkedRadioButtonId)
                val status = radioButton.text.toString()

                Log.i("Nút Create", "Value: " + status)
            }
        }

        // Date of Birth
        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener() {view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
            }

        btnSelectDate.setOnClickListener() {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                             myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        }
    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        edtDate.setText(sdf.format(myCalendar.time))

    }
}
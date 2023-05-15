package com.app.medicine.views.user

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import java.text.SimpleDateFormat
import java.util.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Date of Start and End
        // Viết 1 hàm sài luôn không cần viết ra dài dòng như bên RegisterActivity
        chooseStartAndEndDate(view, view.btnSelectStartDate)
        chooseStartAndEndDate(view, view.btnSelectEndDate)
        return view
    }
    private fun chooseStartAndEndDate(view : View, selectdate : View) {

        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener() { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            if(selectdate == btnSelectStartDate) {
                updateLable(myCalendar, edtStartDate)
            }
            if(selectdate == btnSelectEndDate) {
                updateLable(myCalendar, edtEndDate)
            }
        }
            selectdate.setOnClickListener() {
                DatePickerDialog(
                    requireContext(), datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
    }
    private fun updateLable(myCalendar: Calendar, edt : View) {
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        if(edt == edtStartDate) {
            edtStartDate.setText(sdf.format(myCalendar.time))
        }
        if(edt == edtEndDate) {
            edtEndDate.setText(sdf.format(myCalendar.time))
        }
    }

}
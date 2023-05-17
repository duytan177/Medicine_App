package com.app.medicine.views.user

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Adapter.ProfileAdapter
import com.app.medicine.Adapter.SponsorshipAdapter
import com.app.medicine.Controller.ProfileRequest
import com.app.medicine.Model.ProfileModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var api: Api
    private val listDataProfile: ArrayList<ProfileModel> = ArrayList()
    private val adapter: ProfileAdapter = ProfileAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        api = ServiceGenerator.getInstance().create(Api::class.java)

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Date of Start and End
        // Viết 1 hàm sài luôn không cần viết ra dài dòng như bên RegisterActivity
        chooseStartAndEndDate(view, view.btnSelectStartDate)
        chooseStartAndEndDate(view, view.btnSelectEndDate)

        getAllProfile()

        return view
    }

    private fun getAllProfile() {

//        val request = ProfileRequest()
//        request.id =
        val call = api.getAllProfiles()
        call.enqueue(object : retrofit2.Callback<MutableList<ProfileModel>>{
            override fun onResponse(
                call: Call<MutableList<ProfileModel>>,
                response: Response<MutableList<ProfileModel>>
            ) {
                Log.i("Hihihihi", "${response.body().toString()}")

                if(response.isSuccessful &&
                    response.body() != null) {
                    listDataProfile.addAll(response.body()!!)
                    adapter.setData(listDataProfile)
                    _recyProfileData.adapter = adapter
                    _recyProfileData.layoutManager = LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )

                    // Code lắng nghe sự kiện click lên item
                    adapter.setOnItemClickListener(object : ProfileAdapter.OnItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(requireContext(), ProfileDetailActivity::class.java)

                            val values = response.body()!!;
                            val profile = values[position];
                            intent.putExtra("date",profile.created_at)
                            intent.putExtra("serviceDate",profile.updated_at)
                            intent.putExtra("numAffair",profile.num_affair)
                            intent.putExtra("servicePrice",profile.service_price)
                            intent.putExtra("default",profile.default)
                            intent.putExtra("requestAuthority",profile.request_authority)
                            intent.putExtra("typeofService",profile.type_of_service)
                            startActivity(intent)
                        }
                    })

                }
            }
            override fun onFailure(call: Call<MutableList<ProfileModel>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })
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




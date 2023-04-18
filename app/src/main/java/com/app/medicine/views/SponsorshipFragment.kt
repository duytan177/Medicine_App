package com.app.medicine.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Controller.CityResponse
import com.app.medicine.Model.SponsorshipModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.fragment_sponsorship.*
import kotlinx.android.synthetic.main.fragment_sponsorship.view.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SponsorshipFragment : Fragment() {
    private lateinit var api: Api

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sponsorship, container, false)

        /* Trong Fragment phải khởi tạo view đã rồi mới code tiếp được */
        api = ServiceGenerator.getInstance().create(Api::class.java)

        view.buttontest.setOnClickListener() {
            getSponsorship()
        }
        return view
    }
    private fun getSponsorship() {
        val call = api.getSponsorship()
        call.enqueue(object : retrofit2.Callback<MutableList<SponsorshipModel>>{
            override fun onResponse(
                call: Call<MutableList<SponsorshipModel>>,
                response: Response<MutableList<SponsorshipModel>>
            ) {
                Log.i("Hihihihi", "${response.body().toString()}")

            }

            override fun onFailure(call: Call<MutableList<SponsorshipModel>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })
    }


}
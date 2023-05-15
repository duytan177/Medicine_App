package com.app.medicine.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Adapter.SponsorshipAdapter
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
    private val listDataSponsorShip: ArrayList<SponsorshipModel> = ArrayList()
    private val adapter: SponsorshipAdapter = SponsorshipAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        api = ServiceGenerator.getInstance().create(Api::class.java)

        /* Trong Fragment phải khởi tạo view đã rồi mới code tiếp được */
        val view = inflater.inflate(R.layout.fragment_sponsorship, container, false)
        getSponsorship()

        /* VIEW */
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
                if(response.isSuccessful && response.body() != null) {
                    listDataSponsorShip.clear()
                    listDataSponsorShip.addAll(response.body()!!)
                    if(isAdded()){
                    // Thêm data đã gọi từ API vào trong list, list này là list đã được tạo trong Adapter
                        adapter.setData(listDataSponsorShip)
                        _recySponsorData.adapter = adapter
                        _recySponsorData.layoutManager = LinearLayoutManager(
                            requireContext(),
                            LinearLayoutManager.VERTICAL,
                            false
                        )

                    }
                }
            }
            override fun onFailure(call: Call<MutableList<SponsorshipModel>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })
    }

}
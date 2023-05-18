package com.app.medicine.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Model.UsersModel
import com.app.medicine.R
import retrofit2.Call
import retrofit2.Response

class AdminActivity : AppCompatActivity() {
    private lateinit var api: Api
    private var hasBeenCalled = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        api = ServiceGenerator.getInstance().create(Api::class.java)
        getAllUsers()
    }

    private fun getAllUsers() {
        val call = api.getAllUsers()
        Log.e("call",call.toString())
        call.enqueue(object : retrofit2.Callback<MutableList<UsersModel>>{
            override fun onResponse(call: Call<MutableList<UsersModel>>,response: Response<MutableList<UsersModel>>) {
                Log.i("Hihihihi", "${response.body().toString()}")
            }
            override fun onFailure(call: Call<MutableList<UsersModel>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })

    }
}
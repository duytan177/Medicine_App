package com.app.medicine.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Adapter.SponsorshipAdapter
import com.app.medicine.Adapter.UserAdapter
import com.app.medicine.Auth.RegisterActivity
import com.app.medicine.Model.SponsorshipModel
import com.app.medicine.Model.UsersModel
import com.app.medicine.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.fragment_sponsorship.*
import kotlinx.android.synthetic.main.users_itemview.*
import retrofit2.Call
import retrofit2.Response

class AdminActivity : AppCompatActivity() {
    private lateinit var api: Api
    private val users = UsersModel()
    private val listDataUsers: ArrayList<UsersModel> = ArrayList()
    private val adapter: UserAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        api = ServiceGenerator.getInstance().create(Api::class.java)
        getAllUsers()

        adminAddUser.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        // Filter
        adminSearchUser.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val query = p0.toString().toLowerCase()
                val filteredList = ArrayList<UsersModel>()

                for(user in listDataUsers) {
                    if(user.name?.toLowerCase()!!.contains(query)) {
                        filteredList.add(user)
                    }
                }

                adapter.setData(filteredList)
                _recyUsersData.adapter = adapter
                _recyUsersData.layoutManager = LinearLayoutManager(
                    this@AdminActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }

        })
    }

    private fun getAllUsers() {
        val call = api.getAllUsers()
        call.enqueue(object : retrofit2.Callback<MutableList<UsersModel>>{
            override fun onResponse(
                call: Call<MutableList<UsersModel>>,
                response: Response<MutableList<UsersModel>>
            ) {
                if(response.isSuccessful && response.body() != null) {
                    listDataUsers.clear()
                    listDataUsers.addAll(response.body()!!)
                }
                adapter.setData(listDataUsers)
                _recyUsersData.adapter = adapter
                _recyUsersData.layoutManager = LinearLayoutManager(
                    this@AdminActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                Log.i("Hihihihi", "${response.body()}")
            }

            override fun onFailure(call: Call<MutableList<UsersModel>>, t: Throwable) {
                Log.e("Hohohoho",t.message.toString())
            }

        })

    }
}
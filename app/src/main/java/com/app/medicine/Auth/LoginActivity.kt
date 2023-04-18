package com.app.medicine.Auth

import android.app.ProgressDialog
import android.content.Intent
import android.content.SharedPreferences
//import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import com.app.medicine.API.Api
import com.app.medicine.MainActivity
import com.app.medicine.R
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Model.UserModel
import com.app.medicine.Controller.UserRequest
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class LoginActivity : AppCompatActivity() {
    private lateinit var api: Api
    private lateinit var dialog: ProgressDialog
    private lateinit var sf : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        api = ServiceGenerator.getInstance().create(Api::class.java)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()

        // Btn chuyển hướng tới Register
        btnRegister.setOnClickListener() {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
        btnLogin.setOnClickListener(){
            sendLogin()
        }
    }

    override fun onPause() {
        super.onPause()
        val email = edtEmailLogin.text.toString()
        editor.apply() {
            putString("email", email)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val email = sf.getString("email", null)
    }

    private fun sendLogin() {
        val request = UserRequest()
        request.email = edtEmailLogin.text.toString()
        request.password = edtPasswordLogin.text.toString()

        val call = api.login(request)
        call.enqueue(object : Callback<UserModel>{
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val code = response.code().toString()
                Log.e("Success", response.code().toString())
                if(code == "200"){
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    startActivity(intent)
                }
                Log.e("Success", response.toString())
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {

                Log.e("error",t.message.toString())
            }
        })
    }
}
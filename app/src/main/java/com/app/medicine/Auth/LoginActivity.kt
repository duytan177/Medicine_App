package com.app.medicine.Auth

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.medicine.API.Api
import com.app.medicine.MainActivity
import com.app.medicine.R
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Model.UserModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class LoginActivity : AppCompatActivity() {
    private lateinit var api: Api
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        api = ServiceGenerator.getInstance().create(Api::class.java)

        // Btn chuyển hướng tới Register
        btnRegister.setOnClickListener() {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }

        btnLogin.setOnClickListener(){
            sendLogin()
        }
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
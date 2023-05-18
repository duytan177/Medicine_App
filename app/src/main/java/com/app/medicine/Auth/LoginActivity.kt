package com.app.medicine.Auth

//import android.support.v7.app.AppCompatActivity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Controller.UserRequest

import com.app.medicine.Model.UserModel
import com.app.medicine.R
import com.app.medicine.views.AdminActivity

import com.app.medicine.views.HomeActivity
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
        var progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait....")
        progressDialog.show()

        val request = UserRequest()
        request.email = edtEmailLogin.text.toString()
        request.password = edtPasswordLogin.text.toString()

        val call = api.login(request)
        call.enqueue(object : Callback<UserModel>{
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val code = response.code().toString()
                val role = response.body()?.data?.role.toString()
                val name = response.body()?.data?.name.toString()
                val id = response.body()?.data?.id.toString()
                Log.e("Success", response.body()?.data?.role.toString())
                if(progressDialog.isShowing()) {
                    if(code == "200"&& role == "2"){
                    val intent = Intent(this@LoginActivity,HomeActivity::class.java)
                    intent.putExtra("id",id)
                    intent.putExtra("name",name)
                    intent.putExtra("role",role)
                        progressDialog.dismiss();
                    startActivity(intent)
                    }
                    else if(code == "200"&& role == "1"){
                        val intent = Intent(this@LoginActivity,AdminActivity::class.java)
                        intent.putExtra("id",id)
                        intent.putExtra("name",name)
                        intent.putExtra("role",role)
                        progressDialog.dismiss();
                        startActivity(intent)
                    }
                }
                Log.e("Success", response.toString())
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {

                Log.e("error",t.message.toString())
            }
        })
    }
}
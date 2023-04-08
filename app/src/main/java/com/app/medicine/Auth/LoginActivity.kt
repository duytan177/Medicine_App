package com.app.medicine.Auth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Btn chuyển hướng tới Register
        btnRegister.setOnClickListener() {
//            val i = Intent(this, )
        }
    }
}
package com.app.medicine.views

//import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_drawer.*
import kotlinx.android.synthetic.main.nav_header.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navDrawer.itemIconTintList = null
        imgMenu.setOnClickListener() {
            drawerLayout.openDrawer(GravityCompat.START)
            val id = intent.getStringExtra("id")
            val name = intent.getStringExtra("name")
            val role = intent.getStringExtra("role")
            Log.e("âsd","${id +name+ role}")
            txtuserName.setText(name)
            if(role == "1"){
                txtuserRole.setText("Admintrator")
            }else{
                txtuserRole.setText("User")
            }
        }

        // Fragment Home View
//        val navController = Navigation.findNavController(this, R.id.fragmentHomeView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentHomeView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(navDrawer, navController)

        val textTitle = findViewById<TextView>(R.id.title)
        navController
            .addOnDestinationChangedListener { controller, destination, arguments ->
                textTitle.text = destination.label
            }

    }
}
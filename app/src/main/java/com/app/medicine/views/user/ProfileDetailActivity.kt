package com.app.medicine.views.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.medicine.Adapter.ImageAdapter
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_profile_detail.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        val galleryImage = registerForActivityResult(
            ActivityResultContracts.GetMultipleContents(),
//            ActivityResultCallback {
//                imageProfile.setImageURI(it)
//            } =>>>> One image choosse
            ActivityResultCallback { images ->
                    _recyImages.adapter = ImageAdapter(images)
                    _recyImages.layoutManager = LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
            }
        )
        btnChooseImageUpdateProfile.setOnClickListener() {
            galleryImage.launch("image/*")
        }

        btnSendImageUpdateProfile.setOnClickListener() {

        }
    }
}
package com.app.medicine.views.user

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.medicine.API.Api
import com.app.medicine.API.ServiceGenerator
import com.app.medicine.Adapter.ImageAdapter
import com.app.medicine.Controller.UploadProfileRequest
import com.app.medicine.Model.ProfileUploadModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.activity_profile_detail.*
import kotlinx.android.synthetic.main.fragment_profile.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ProfileDetailActivity : AppCompatActivity() {
    private lateinit var api: Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)
        api = ServiceGenerator.getInstance().create(Api::class.java)


        val date = intent.getStringExtra("date");
        val serviceDate = intent.getStringExtra("serviceDate");
        val numAffair = intent.getStringExtra("numAffair");
        val servicePrice = intent.getStringExtra("servicePrice");
        val default = intent.getStringExtra("default");
        val requestAuthority = intent.getStringExtra("requestAuthority");
        val typeofService = intent.getStringExtra("typeofService");


        val edtStartDate = findViewById<EditText>(R.id.edtStartDate);
        val edtEndDate = findViewById<EditText>(R.id.edtEndDate);
        val edtNumAffair = findViewById<EditText>(R.id.edtNumAffair);
        val edtPrice = findViewById<EditText>(R.id.edtPrice);
        val edtDefaultJuris = findViewById<EditText>(R.id.edtDefaultJuris);
        val edtRequestingAuthority = findViewById<EditText>(R.id.edtRequestingAuthority);
        val edtTypeOfService = findViewById<EditText>(R.id.edtTypeOfService);


        edtStartDate.setText(date);
        edtEndDate.setText(serviceDate);
        edtNumAffair.setText(numAffair);
        edtPrice.setText(servicePrice);
        edtDefaultJuris.setText(default);
        edtRequestingAuthority.setText(requestAuthority);
        edtTypeOfService.setText(typeofService);


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
        btnChooseImageProfile.setOnClickListener() {
            galleryImage.launch("image/*")
        }

        btnSendImageProfile.setOnClickListener() {
            val request = UploadProfileRequest();
            request.date = edtStartDate.text.toString()
            request.serviceDate = edtEndDate.text.toString()
            request.numberAffair = edtNumAffair.text.toString()
            request.servicePrice = edtPrice.text.toString()
            request.default = edtDefaultJuris.text.toString()
            request.authority = edtRequestingAuthority.text.toString()
            request.service = edtTypeOfService.text.toString()
            request.imageUpload = btnChooseImageProfile.urls.toString()

            val call = api.getUploadImage(request)
            call.enqueue(object : retrofit2.Callback<MutableList<ProfileUploadModel>>{
                override fun onResponse(
                    call: Call<MutableList<ProfileUploadModel>>,
                    response: Response<MutableList<ProfileUploadModel>>
                ) {
                    Log.i("success",response.body().toString())
                }

                override fun onFailure(call: Call<MutableList<ProfileUploadModel>>, t: Throwable) {
                    Log.e("error",t.message.toString())
                }
            })
        }
    }
}
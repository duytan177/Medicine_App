package com.app.medicine.Adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.medicine.Model.ProfileModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.image_itemview.view.*
import kotlinx.android.synthetic.main.profile_itemview.view.*

class ImageAdapter(private val images: List<Uri>): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProfile: ImageView = itemView.imageProfile

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = ImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.image_itemview, parent, false)
        )
        return itemView
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUri = images[position]

        if (holder is ImageViewHolder)
        {
            holder.imageProfile.setImageURI(imageUri)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
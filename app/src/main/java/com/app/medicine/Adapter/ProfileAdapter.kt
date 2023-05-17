package com.app.medicine.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.medicine.Model.ProfileModel
import com.app.medicine.Model.SponsorshipModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.profile_itemview.view.*
import kotlinx.android.synthetic.main.sponsorship_itemview.view.*

class ProfileAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var mListener: OnItemClickListener
    private var listDataProfile: List<ProfileModel> = ArrayList()

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: OnItemClickListener) {
        mListener = clickListener
    }

    public fun setData(listDataProfile: List<ProfileModel>) {
        this.listDataProfile = listDataProfile
    }

    override fun getItemCount(): Int {
        return listDataProfile.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemview = AdapterProfileHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.profile_itemview, parent, false)
            ,mListener

        )
        return itemview
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AdapterProfileHolder)
        {
            holder.bindingData(listDataProfile.get(position))
        }
    }

     class AdapterProfileHolder constructor(itemView: View, clickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView)
        {
            init {
                itemView.setOnClickListener() {
                    clickListener.onItemClick(adapterPosition)
                }
            }
            private val nameProfile: TextView = itemView.txtNameProfile
            private val dateProfile: TextView = itemView.txtDateProfile
            private val numProfile: TextView = itemView.txtNumProfile

            fun bindingData(pModel: ProfileModel)
            {
                nameProfile.text = pModel.name
                dateProfile.text = pModel.created_at
                numProfile.text = pModel.num_affair
            }
        }


}
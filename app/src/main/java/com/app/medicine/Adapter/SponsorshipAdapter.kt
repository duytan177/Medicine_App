package com.app.medicine.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.medicine.Model.SponsorshipModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.sponsorship_itemview.view.*

class SponsorshipAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listDataSponsorship: List<SponsorshipModel> = ArrayList()

    public fun setData(listDataSponsorship: List<SponsorshipModel>) {
        this.listDataSponsorship = listDataSponsorship
    }
    override fun getItemCount(): Int {
        return listDataSponsorship.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AdapterSponsorshipHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sponsorship_itemview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AdapterSponsorshipHolder)
        {
            holder.bindingData(listDataSponsorship.get(position))
        }
    }

    public class AdapterSponsorshipHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView)
    {
        private val nameSponsorship: TextView = itemView.txtNameSponsorship
        private val dateSponsorship: TextView = itemView.txtDateSponsorship
        private val activeSponsorship: TextView = itemView.txtActiveSponsorship

        fun bindingData(sssModel: SponsorshipModel)
        {
            nameSponsorship.text = sssModel.name
            dateSponsorship.text = sssModel.date
            if(sssModel.active == 1) {
                activeSponsorship.text = "Active"
            } else {
                activeSponsorship.text = "No Active"
            }
        }
    }
}
package com.app.medicine.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.medicine.Model.SponsorshipModel
import com.app.medicine.Model.UsersModel
import com.app.medicine.R
import kotlinx.android.synthetic.main.sponsorship_itemview.view.*
import kotlinx.android.synthetic.main.users_itemview.view.*

class UserAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listDataUsers: List<UsersModel> = ArrayList()

    public fun setData(listDataUsers: List<UsersModel>) {
        this.listDataUsers = listDataUsers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AdapterUserHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.users_itemview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listDataUsers.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AdapterUserHolder)
        {
            holder.bindingData(listDataUsers.get(position))

        }
    }

    public class AdapterUserHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView)
    {
        private val statusUser: ImageView = itemView.imvStatus
        private val userUserName: TextView = itemView.txtUserUsername
        private val regisdateUser: TextView = itemView.txtRegisdate
        private val percentageUser: TextView = itemView.txtPercentage
        private val delete: ImageButton = itemView.btnUserDelete

        fun bindingData(uModel: UsersModel)
        {
            if(uModel.active == 1) {
                statusUser.setImageResource(R.drawable.circle_active)
            } else {
                statusUser.setImageResource(R.drawable.circle_noactive)
            }
            userUserName.text = uModel.name
            regisdateUser.text = uModel.created_at
            percentageUser.text = uModel.percentage
            delete.setImageResource(R.drawable.delete)

        }
    }

}
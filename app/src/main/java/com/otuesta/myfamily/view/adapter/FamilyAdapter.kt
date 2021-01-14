package com.otuesta.myfamily.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.otuesta.myfamily.R
import com.otuesta.myfamily.model.Family

class FamilyAdapter(val familyListener: FamilyListener) :
    RecyclerView.Adapter<FamilyAdapter.ViewHolder>() {

    val listFamily = ArrayList<Family>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_family, parent, false))

    override fun onBindViewHolder(holder: FamilyAdapter.ViewHolder, position: Int) {
        val family = listFamily[position]

        holder.tvName.text = family.name
        holder.tvBirthday.text = family.birthday
        holder.tvPhone.text = family.phone

        if (position%2==0){
            holder.cvItemFamily.setBackgroundColor(Color.CYAN)
        }

        Glide.with(holder.itemView.context)
            .load(family.photo)
            .into(holder.ivPhoto)

        holder.itemView.setOnClickListener {
            familyListener.onFamilyClicked(family, position)
        }
    }

    override fun getItemCount(): Int {
        return listFamily.size
    }

    fun updateData(data: List<Family>) {
        listFamily.clear()
        listFamily.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvBirthday = itemView.findViewById<TextView>(R.id.tvBirthday)
        val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)
        val ivPhoto = itemView.findViewById<ImageView>(R.id.ivPhoto)
        val cvItemFamily = itemView.findViewById<CardView>(R.id.cvItemFamily)
    }

}
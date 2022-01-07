package com.example.lwl_2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView


class BannerAdapter(val activity: HeadPage, val List: List<Banner>):RecyclerView.Adapter<BannerAdapter.ViewHolder>(){

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val ban: TextView = view.findViewById(R.id.tx)
        val pic1:ImageView = view.findViewById(R.id.im1)
        val pic2:ImageView = view.findViewById(R.id.im2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_page,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val banners = List[position]
            val ban = banners.content
            val pic1 = banners.id_1
            val pic2 = banners.id_2
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banners = List[position]
        holder.ban.text = banners.content
        holder.pic1.setImageResource(banners.id_1)
        holder.pic2.setImageResource(banners.id_2)
    }

    override fun getItemCount(): Int {
        return List?.size
    }

}
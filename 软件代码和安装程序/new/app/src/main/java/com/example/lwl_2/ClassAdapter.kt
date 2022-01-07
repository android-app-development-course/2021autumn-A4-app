package com.example.lwl_2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lwl_2.entity.Room

class ClassAdapter (val activity: ClassPage1, val classList: List<Room>,val my:String): RecyclerView.Adapter<ClassAdapter.ViewHolder>(){

    private var context: Context? = null
    //intent.putExtra("username",username)
    public fun MyAdapter(context: Context)
    {
        this.context=context;
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {


        val name:TextView = view.findViewById(R.id.name)
        val type:TextView = view.findViewById(R.id.type)
        val class_size:TextView = view.findViewById(R.id.class_size)
        val num:TextView = view.findViewById(R.id.num)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.base_page, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val clas = classList[position]
            val id = clas.objectId
            val type = clas.room_type
            val name = clas.room_name
            val all = clas.all.toInt()
            val number = clas.size.toInt()
            val info = clas.room_info
            val username = clas.username
            //这里要判断数据类型和人数
            if(all>number)
            {
                if (type=="多人课室")
                {
                    val intent = Intent(viewHolder.itemView.context, MorepeoplePage::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("all",all)
                    intent.putExtra("num",number)
                    intent.putExtra("type",type)
                    intent.putExtra("info",info)
                    intent.putExtra("id",id)
                    intent.putExtra("username",username)
                    intent.putExtra("user_id",my)
                    activity.startActivity(intent);
                }
                if(type=="双人课室")
                {
                    val intent = Intent(viewHolder.itemView.context, TwopeoplePage::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("all",all)
                    intent.putExtra("num",number)
                    intent.putExtra("id",id)
                    intent.putExtra("type",type)
                    intent.putExtra("info",info)
                    intent.putExtra("username",username)
                    intent.putExtra("user_id",my)
                    activity.startActivity(intent);
                }
            }

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val clas = classList[position]
        holder.name.text = clas.room_info
        holder.type.text = clas.room_type
        holder.num.text = clas.size.toString()
        holder.class_size.text = clas.all.toString()
    }

    override fun getItemCount(): Int = classList.size






}
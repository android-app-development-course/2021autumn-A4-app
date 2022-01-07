package com.example.lwl_2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.lwl_2.entity.friend

class friendAdapter(activity: Activity, val resourceId: Int, data: List<friend>) :
    ArrayAdapter<friend>(activity, resourceId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //首先使用LayoutInflater子项加载我们的布局，三个参数。
        // 最后一个false的意思是父布局声明的layout生效，不会为该View增加父布局。保准写法
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
        //获取到ImageView和TextView的实例
        val Name: TextView = view.findViewById(R.id.fri_item_name)
        //得到当前项的Fruit实例
        val u = getItem(position)
        //设置图片和文字
        if (u != null) {
            Name.text = u.getuser1()
        }
        //将布局返回
        return view
    }
}
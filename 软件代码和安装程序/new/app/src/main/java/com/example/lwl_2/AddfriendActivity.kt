package com.example.lwl_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class AddfriendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addfriend)

        val add: Button =findViewById(R.id.addfri_add_btn)
        val back: ImageButton =findViewById(R.id.friadd_back_button)
        val name: TextView =findViewById(R.id.addfri_name_tv)

        //接收参数
        name.text= intent.getStringExtra("username")

        add.setOnClickListener {
            Toast.makeText(this, "已发送好友申请", Toast.LENGTH_SHORT).show()

        }
        back.setOnClickListener { finish() }

    }
}
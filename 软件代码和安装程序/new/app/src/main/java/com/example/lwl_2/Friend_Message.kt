package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout

class Friend_Message : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_message)
        val goto_friendlist:Button = findViewById(R.id.goto_friendlist)
        goto_friendlist.setOnClickListener {
            val intent = Intent(this,Friend_View::class.java)
            startActivity(intent)
        }
        val friend_mes_back_button:ImageButton = findViewById(R.id.friend_mes_back_button)
        friend_mes_back_button.setOnClickListener {
            finish()
        }
        /*chat_linearlayout.setOnClickListener {
            val intent = Intent(this,Chat::class.java)
            startActivity(intent)
        }*/


    }

    fun chat(view: View) {
        var num=1
        when(view.id){
            R.id.chat1_linearlayout->num=1
            R.id.chat2_linearlayout->num=2

        }
        val intent = Intent(this, Chat::class.java)
        intent.putExtra("num", num)
        startActivity(intent)


    }

    }
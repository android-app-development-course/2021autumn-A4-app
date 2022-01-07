package com.example.lwl_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ClassmessagePage : AppCompatActivity() {
    private var className:String = "无"
    private var classType:String = "无"
    private var classTotal = 0
    private var classNow = 0
    private var classInfo:String = "无"
    override fun onCreate(savedInstanceState: Bundle?) {
        className = intent.getStringExtra("name")
        classType = intent.getStringExtra("type")
        classInfo = intent.getStringExtra("info")
        classTotal = intent.getIntExtra("all",0)
        classNow = intent.getIntExtra("num",0)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classmessage_page)
        val name: TextView = findViewById(R.id.className)
        name.setText(className)
        val type: TextView = findViewById(R.id.classType)
        type.setText(classType)
        val total: TextView = findViewById(R.id.classTotal)
        total.setText(classTotal.toString())
        val now: TextView = findViewById(R.id.classNow)
        now.setText(classNow.toString())
        val info: TextView = findViewById(R.id.classInfo)
        info.setText(classInfo)
        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }
    }
}
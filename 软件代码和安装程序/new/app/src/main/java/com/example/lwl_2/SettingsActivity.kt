package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //初始化组件
        val save:Button=findViewById(R.id.settings_save_btn)
        val back:ImageButton=findViewById(R.id.setting_back_button)
        back.setOnClickListener {
            finish()
        }
    }

    fun save(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("确认")
        builder.setMessage("是否保存修改后的设置？")
        builder.setPositiveButton("确认") { dialog, which ->}
        builder.setNegativeButton("取消") {  dialog, which -> }
        val alert = builder.create()
        alert.show()

    }


}
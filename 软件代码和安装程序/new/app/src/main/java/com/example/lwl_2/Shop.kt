package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class Shop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        val shop_back_button: ImageButton = findViewById(R.id.shop_back_button)
        val b1:Button=findViewById(R.id.shop_1_btn)
        val b2:Button=findViewById(R.id.shop_2_btn)
        val b3:Button=findViewById(R.id.shop_3_btn)
        val b4:Button=findViewById(R.id.shop_4_btn)
        val b5:Button=findViewById(R.id.shop_5_btn)

        shop_back_button.setOnClickListener {
            val intent = Intent(this, HeadPage::class.java)
            startActivity(intent)
        }
        b1.setOnClickListener {
            if(b1.text != "使用"){
            Toast.makeText(this, "购买成功！", Toast.LENGTH_SHORT).show()

            b1.text="使用"}
            Toast.makeText(this, "把表情发送给小伙伴吧", Toast.LENGTH_SHORT).show()


        }
        b2.setOnClickListener {
            if(b1.text != "使用"){
                Toast.makeText(this, "购买成功！", Toast.LENGTH_SHORT).show()

                b1.text="使用"}
            Toast.makeText(this, "把表情发送给小伙伴吧", Toast.LENGTH_SHORT).show()


        }
        b3.setOnClickListener {
            if(b1.text != "使用"){
                Toast.makeText(this, "购买成功！", Toast.LENGTH_SHORT).show()

                b1.text="使用"}
            Toast.makeText(this, "把表情发送给小伙伴吧", Toast.LENGTH_SHORT).show()


        }
        b4.setOnClickListener {
            if(b1.text != "使用"){
                Toast.makeText(this, "购买成功！", Toast.LENGTH_SHORT).show()

                b1.text="使用"}
            Toast.makeText(this, "把表情发送给小伙伴吧", Toast.LENGTH_SHORT).show()


        }
        b5.setOnClickListener {
            if(b1.text != "使用"){
                Toast.makeText(this, "购买成功！", Toast.LENGTH_SHORT).show()

                b1.text="使用"}
            Toast.makeText(this, "把表情发送给小伙伴吧", Toast.LENGTH_SHORT).show()


        }
    }

    fun buy(view: View) {
        Toast.makeText(this, "购买成功！", Toast.LENGTH_SHORT).show()

    }
}
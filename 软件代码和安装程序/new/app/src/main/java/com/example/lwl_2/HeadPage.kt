package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class HeadPage : AppCompatActivity() {

    private val contactsList = ArrayList<Banner>()
    var listView: ListView? = null
    var number_to :String = "123"
    var name:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        if(intent?.getStringExtra("user_id")!=null)
        {
            name = intent.getStringExtra("user_id")
            System.out.println("我是  "+ name)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_head_page)
        val chat:ImageButton = findViewById(R.id.chat)
        chat.setOnClickListener {
            val intent = Intent(this, Friend_Message::class.java)
            //intent.putExtra("user_id","$name")
            startActivity(intent)
        }
        val toclass:ImageButton = findViewById(R.id.toclass)
        toclass.setOnClickListener {
            val intent = Intent(this, ClassPage1::class.java)
            intent.putExtra("user_id","$name")
            startActivity(intent)
        }

        val toshop :ImageButton =findViewById(R.id.toshop)
        toshop.setOnClickListener {
            val intent = Intent(this, Shop::class.java)
            //intent.putExtra("user_id","$name")
            startActivity(intent)
        }

        val tofriend:ImageButton = findViewById(R.id.tofriend)
        tofriend.setOnClickListener {
            val intent = Intent(this, Friend_View::class.java)
            intent.putExtra("user_id","$name")
            startActivity(intent)
        }

        val tomine:ImageButton = findViewById(R.id.tomine)
        tomine.setOnClickListener {
            val intent = Intent(this, My::class.java)
            intent.putExtra("user_id","$name")
            startActivity(intent)
        }

        init()
        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val list:RecyclerView = findViewById(R.id.r1)
        list.layoutManager = layoutManager
        val adapter = BannerAdapter(this,contactsList)
        list.adapter = adapter
    }

    private fun init()
    {
        repeat(1)
        {
            contactsList.add(Banner(R.drawable.ban,R.drawable.img1,"#寒假自律挑战：1月20日至2 月15日，完成自习60小时即可 获得1000Co币。"))
            contactsList.add(Banner(R.drawable.ban,R.drawable.img2,"在应用商店给自习室五星好评 后，上传截图，即可获得500 Co币。每人仅参加一次。"))
            contactsList.add(Banner(R.drawable.ban,R.drawable.img4,"在各大网络平台对LWL线上自习室进行安利，上传截图，即可获得500 Co币。每人仅参加一次"))
            contactsList.add(Banner(R.drawable.img3,0,"  "))
        }
    }
}
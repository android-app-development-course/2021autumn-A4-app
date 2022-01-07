package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.UpdateListener
import com.example.lwl_2.entity.Room

class TwopeoplePage : AppCompatActivity() {
    var name1 :String = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twopeople_page)
        //去除默认标题栏
        val context = applicationContext
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val info = intent.getStringExtra("info")
        val type = intent.getStringExtra("type")
        val all:Int = intent.getIntExtra("all",0)
        var num = intent.getIntExtra("num",0)
        name1 = intent.getStringExtra("user_id").toString()
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }
        val check: LinearLayout = findViewById(R.id.two_check_class)
        check.setOnClickListener {
            val intent1 = Intent(this,ClassmessagePage::class.java)
            intent1.putExtra("name", name)
            intent1.putExtra("type",type)
            intent1.putExtra("all",all)
            intent1.putExtra("num",num)
            intent1.putExtra("info",info)
            intent.putExtra("user_id","$name1")
            startActivity(intent1)
        }

        val choose:ImageButton = findViewById(R.id.make)
        choose.setOnClickListener {
            if(num==all)
            {
                Toast.makeText(this,"课室已经满人！",Toast.LENGTH_SHORT).show()
            }
            else{
                num = num+1//人数加一
                val room = Room()
                room.size = num
                //room.all = all
                room.objectId = id
                System.out.println("objectId"+id)
                room.update("$id",object :UpdateListener(){
                    override fun done(e: BmobException?) {
                        if(e==null)
                        {
                            System.out.println("更新成功")
                            startActivity(Intent(context,GirlPage::class.java))
                        }
                        else{
                            System.out.println("更新失败")
                        }
                    }
                })
            }
        }

        val back:ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this, ClassPage1::class.java)
            intent.putExtra("user_id","$name1")
            startActivity(intent)
        }

    }
}
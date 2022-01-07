package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.bmob.v3.listener.SaveListener
import cn.bmob.v3.listener.UpdateListener
import com.example.lwl_2.entity.Room
import com.example.lwl_2.entity.User
import com.example.lwl_2.entity.friend

class MorepeoplePage : AppCompatActivity() {
    var name1 :String = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        //intent.putExtra("username",username)
        val username = intent.getStringExtra("username")
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val info = intent.getStringExtra("info")
        val type = intent.getStringExtra("type")
        val all:Int = intent.getIntExtra("all",0)
        var num = intent.getIntExtra("num",0)
        val my = intent.getStringExtra("user_id")
        name1 = intent.getStringExtra("user_id").toString()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morepeople_page)
        val back:ImageButton = findViewById(R.id.back)
        back.setOnClickListener{
            val intent = Intent(this, ClassPage1::class.java)
            intent.putExtra("user_id","$name1")
            startActivity(intent)
        }
        val check:LinearLayout = findViewById(R.id.check_class)
        check.setOnClickListener {
            //查看信息
            val intent1 = Intent(this,ClassmessagePage::class.java)
            intent1.putExtra("name", name)
            intent1.putExtra("type",type)
            intent1.putExtra("all",all)
            intent1.putExtra("num",num)
            intent1.putExtra("info",info)
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
                room.all = all
                room.objectId = id
                System.out.println("objectId"+id)
                room.update("$id",object :UpdateListener(){
                    override fun done(e: BmobException?) {
                        if(e==null)
                        {
                            System.out.println("多人更新成功")
                        }
                        else{
                            System.out.println("更新失败")
                        }
                    }

                })
                //跳转到倒计时
                val intent1 = Intent(this,GirlPage::class.java)
                intent1.putExtra("id",id)//把课室id和学习人数传过去
                intent1.putExtra("num",num)
                intent1.putExtra("all",all)
                startActivity(intent1)
            }
        }
        val addfriend:Button = findViewById(R.id.addfriend)
        //查看用户
        addfriend.setOnClickListener {
            //Toast.makeText(this,"添加好友成功！",Toast.LENGTH_SHORT).show()
            //添加房主
            val f=  friend()
            f.setuser1(username)
            f.setuser2(my)
            f.save(object :SaveListener<String>(){
                override fun done(p0: String?, e: BmobException?) {
                    if (e==null)
                    {
                        temp()
                        System.out.println("添加成功")
                    }
                }

            })

        }

    }
    private fun temp()
    {
        Toast.makeText(this, "添加成功！", Toast.LENGTH_SHORT).show()
    }
}
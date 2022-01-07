package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.example.lwl_2.entity.Room

class CreatedPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_created_page)

        val type: EditText = findViewById(R.id.type)
        val number: EditText = findViewById(R.id.number)
        val name: EditText = findViewById(R.id.name)
        val info: EditText = findViewById(R.id.info)
        //获取传进来的值
        val user_id:String = "345"

        val back:ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }

        val make:ImageButton = findViewById(R.id.make)
        make.setOnClickListener {
            //根据创建的课室类型 进入一个学习的课室//假设这里是双人课室
            val room = Room()
            //查询room_id
            /*
            var q: BmobQuery<Room> = BmobQuery()
            q.addQueryKeys("room_id")
            q.findObjects(object:FindListener<Room>(){
                override fun done(list:List<Room>, e: BmobException?) {
                    if (e==null&&list!=null)
                    {
                        System.out.println("查询....")
                        temp = (list.get(list.size-1).room_id).toInt()+1
                        System.out.println(temp)
                    }else{
                        System.out.println("查询失败")
                    }
                    temp = (list.get(list.size-1).room_id).toInt()+1
                    room.room_id = temp
                    System.out.println("root"+room.room_id)
                }
            })
             */
            //room.room_id = temp
            //System.out.println("roo"+room.room_id)
            room.room_type = type.text.toString()
            //tem =number.text.toString().toInt()
            if(type.text.toString()=="双人课室")
            {
                room.all=2
                room.size=0
            }
            else {
                //System.out.println("number:"+number.text.toString())
                room.all = number.text.toString().toInt()
                room.size = 0
            }
            //System.out.println("number11:"+number.text.toString())
            room.room_name = name.text.toString()
            room.room_info = info.text.toString()
            room.username = user_id
            room.save(object : SaveListener<String>() {
                override fun done(objectId: String?, e: BmobException?) {
                    if (e == null) {
                        println("添加数据成功，返回objectId为：$objectId")
                    } else {
                        println("创建数据失败：" + e.message)
                    }
                }
            })

            if(room.all==2)
            {
                //进入双人并且传参
                val intent = Intent(this, TwopeoplePage::class.java)
                intent.putExtra("room_id",room.room_id)
                startActivity(intent)
            }else{
                val intent = Intent(this, MorepeoplePage::class.java)
                intent.putExtra("room_id",room.room_id)
                startActivity(intent)
            }
        }
    }
}
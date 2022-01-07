package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.UpdateListener
import com.example.lwl_2.entity.Room
import java.text.SimpleDateFormat
import java.util.*

class GirlPage : AppCompatActivity() {

    var Durtime: Long = 10
    var leftTime = Durtime
    val final:Long = 0
    var inputtime:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_girl_page)
        val btn_save_pop:Button = findViewById(R.id.btn_save_pop)
        val create_user_dialog_view:LinearLayout = findViewById(R.id.create_user_dialog_view)
        val text_mobile:EditText = findViewById(R.id.text_mobile)
        val id = intent.getStringExtra("id")//课室id
        //val all = intent.getStringExtra("all")
        //System.out.println("all"+all.toString().toInt())
        val ch: Chronometer = findViewById(R.id.ch)
        val mineAgain:ImageButton = findViewById(R.id.mineAgin)
        var num = intent.getIntExtra("num",0)//课室人数
        val back:ImageButton = findViewById(R.id.back)
        back.setOnClickListener{
            //设置一个弹窗，提醒她是否要退出学习
            Toast.makeText(this,"请即使返回学习哦！",Toast.LENGTH_SHORT).show()
            num = num -1
            val room = Room()
            //room.all = all.toInt()
            room.objectId = id
            room.size = num
            room.update(object : UpdateListener(){
                override fun done(e: BmobException?) {
                    if(e==null)
                    {
                        System.out.println("更新成功")
                    }
                    else{
                        System.out.println("更新失败")
                    }
                }
            })
            finish()
        }//退出

        val button:ImageButton = findViewById(R.id.button)
        button.setOnClickListener {
            //读取用户id判断她的学习状态
            Toast.makeText(this,"请即使返回学习哦！",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Friend_Message::class.java)
            startActivity(intent)
        }//查看消息

        btn_save_pop.setOnClickListener{
            inputtime = text_mobile.text.toString().toInt()
            create_user_dialog_view.visibility= View.INVISIBLE
        }//输入学习时间


        ch.setOnChronometerTickListener {
            leftTime--
            val d = Date(leftTime * 1000)

            val timeFormat = SimpleDateFormat("mm:ss")

            ch.text = timeFormat.format(d)
            if (leftTime==final) {
                Toast.makeText(this, "时间到了~", Toast.LENGTH_SHORT).show();
                ch.stop()
                //记录时长

            }
        }

        mineAgain.setOnClickListener {
            ch.stop()
            create_user_dialog_view.visibility= View.VISIBLE
            ch.setBase(SystemClock.elapsedRealtime())
            leftTime = Durtime
            val d = Date(leftTime * 1000)

            val timeFormat = SimpleDateFormat("mm:ss")

            ch.text = timeFormat.format(d)
        }//重置时间

        val start:ImageButton = findViewById(R.id.start)
        start.setOnClickListener {
            leftTime = inputtime.toLong()*60//剩余时间
            Durtime = inputtime.toLong()
            ch.start()
        }

    }
}
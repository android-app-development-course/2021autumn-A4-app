package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.example.lwl_2.entity.User
import com.example.lwl_2.entity.friend

class My : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        //初始化组件
        val my_back_button: ImageButton = findViewById(R.id.my_back_button)
        val my_name_tv: TextView =findViewById(R.id.my_name_tv)
        val time_h: TextView =findViewById(R.id.my_time_h_tv)
        val time_m: TextView =findViewById(R.id.my_time_m_tv)
        val settings: Button =findViewById(R.id.my_settings_btn)
        val fb: Button =findViewById(R.id.my_feedback_btn)
        val logout: Button =findViewById(R.id.my_logout_btn)
        val frinum: TextView =findViewById(R.id.my_frinum_tv)
        val name = intent.getStringExtra("user_id").toString()

        my_back_button.setOnClickListener {
            val intent = Intent(this, HeadPage::class.java)
            intent.putExtra("user_id","$name")
            startActivity(intent)
        }

        //val username = intent.getStringExtra("username")
        //查询对应用户
        //val UserBmobQuery: BmobQuery<User> = BmobQuery<User>()
        var UserBmobQuery: BmobQuery<User> = BmobQuery()
        UserBmobQuery.addWhereEqualTo("username", name)
        UserBmobQuery.findObjects(object : FindListener<User>() {
            override fun done(userl: List<User>?, e: BmobException?) {
                if (e == null) {
                    val u : User =userl!!.get(0)
                    my_name_tv.text=u.username
                    time_h.text=(u.learn_time/60).toString()
                    time_m.text=(u.learn_time%60).toString()

                } else {
                    Log.e("BMOB", e.toString())
                }
            }
        })


        //查询好友个数
        val FriBmobQuery: BmobQuery<friend> = BmobQuery()
        //FriBmobQuery.addWhereEqualTo("user1", username)
        FriBmobQuery.addWhereEqualTo("user2",name)
        FriBmobQuery.findObjects(object : FindListener<friend>() {
            override fun done(friendl: List<friend>?, e: BmobException?) {
                if (e == null) {
                    frinum.text= friendl!!.size.toString()

                } else {
                    Log.e("BMOB", e.toString())
                }
            }
        })

        //跳转设置
        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        //反馈途径
        fb.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("反馈")
            builder.setMessage("感谢您的建议，改进意见请发送至740233990@qq.com。使用满意请给个好评吧")
            builder.setPositiveButton("五星好评") { dialog, which -> }
            builder.setNegativeButton("残忍拒绝") {  dialog, which -> }
            val alert = builder.create()
            alert.show()
        }

        //退出登录
        logout.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}
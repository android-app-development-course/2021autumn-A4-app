package com.example.lwl_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.example.lwl_2.entity.User
import com.example.lwl_2.entity.friend

class Friend_View : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_view)

        //
        val context: Context =baseContext

        //初始化组件
        val goto_friend_message: Button = findViewById(R.id.goto_friend_message)
        val friend_mes_back_button: ImageButton = findViewById(R.id.friend_mes_back_button)
        val find:ImageButton =findViewById(R.id.friendview_find_btn)
        val findid: EditText =findViewById(R.id.friendview_id_edt)
        val list: ListView =findViewById(R.id.fri_view_lv)

        //存在用户为真
        var id_have:Boolean = false

        //点击事件
        goto_friend_message.setOnClickListener {
            val intent = Intent(this,Friend_Message::class.java)
            startActivity(intent)
        }
        friend_mes_back_button.setOnClickListener {
            finish()
        }
        find.setOnClickListener {
            val id=findid.text.toString()

            //查询id是否存在并操作
            //查询对应用户
            val UserBmobQuery: BmobQuery<User> = BmobQuery<User>()


            UserBmobQuery.addWhereEqualTo("username", id)
            UserBmobQuery.findObjects(object : FindListener<User>() {
                override fun done(userl: List<User>?, e: BmobException?) {
                    if (e == null) {
                        id_have=true
                    } else {
                        id_have=false
                        Log.e("BMOB", e.toString())
                    }
                }
            })
            if(id_have){
                val intent = Intent(this, AddfriendActivity::class.java)
                //putExtra接受的是键值对，第一个参数是键，用于后面取值；第二个是真正要传递的数据
                intent.putExtra("username", id)
                startActivity(intent)
            }else{
                Toast.makeText(this, "用户不存在", Toast.LENGTH_SHORT).show()
            }
        }

        //用户列表
        //var namel=ArrayList<User>()

        //查询
        val bmobQuery: BmobQuery<friend> = BmobQuery()
        //bmobQuery.addQueryKeys("123")
        bmobQuery.addWhereEqualTo("user2","123")
        bmobQuery.findObjects(object : FindListener<friend>() {
            override fun done(querylist: List<friend>, e: BmobException?) {
                if (e == null) {

                    val adapter = friendAdapter(this@Friend_View, R.layout.friend_view_item, querylist)
                    //最后利用setAdapter方法将构建好的适配器传递进去，这样ListView和数据之间的关联算是搞定了
                    list.adapter = adapter
                    //注意：这里的Person对象中只有指定列的数据。
                } else {
                    Log.i("bmob", "失败：" + e.message + "," + e.errorCode)
                }
            }
        })

    }
}
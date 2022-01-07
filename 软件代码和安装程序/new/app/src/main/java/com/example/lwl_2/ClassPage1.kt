package com.example.lwl_2

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.bmob.v3.Bmob
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import com.example.lwl_2.entity.Room
import com.example.lwl_2.entity.User
import kotlinx.android.synthetic.main.activity_class_page1.*
import kotlinx.android.synthetic.main.base_page.*
import java.util.ArrayList



class ClassPage1 : AppCompatActivity() {
    var username = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        if(intent?.getStringExtra("user_id")!=null)
        {
            username = intent.getStringExtra("user_id")
            System.out.println("我是  "+ username)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_page1)
        Bmob.initialize(this, "8fdad39ac6d95c7ab098b496126324bd")
        val layoutManager = LinearLayoutManager(this)
        val listview:RecyclerView = findViewById(R.id.r1)
        listview.layoutManager = layoutManager
        val back:ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this, HeadPage::class.java)
            intent.putExtra("user_id","$username")
            startActivity(intent)
        }

        val create:Button = findViewById(R.id.createclass)
        create.setOnClickListener{
            val intent = Intent(this, CreatedPage::class.java)
            //intent.putExtra("user_id","$username")
            startActivity(intent)
        }

        //搜索按钮要不要？后面再加
        val search:ImageButton = findViewById(R.id.search)
        search.setOnClickListener {
            val intent = Intent(this, ClassPage1::class.java)
            startActivity(intent)
        }

        //RecyclerView里面的东西还没初始化，是点击整个方框就可以
        //放了一个做跳转测试 //进入双人课室，这里要判断可是类型，然后进入不同的课室
        /*
        val listview:RelativeLayout = findViewById(R.id.r1)
        listview.setOnClickListener{
            val intent = Intent(this, TwopeoplePage::class.java)
            startActivity(intent)
        }
         */
    }

    //连接数据库读取数据展示在页面上
    override fun onResume() {
        super.onResume()
        val layoutManager = LinearLayoutManager(this)
        // 从数据库中读取数据
        val q:BmobQuery<Room> = BmobQuery()
        q.findObjects(object :FindListener<Room>(){
            override fun done( list:List<Room>? ,e:BmobException?){
                if (e==null)
                {
                    // System.out.println("查询成功"+list.get(0).room_id);
                    val listview:RecyclerView = findViewById(R.id.r1)
                    if(list!=null)
                    {
                        //System.out.println("课室非空！")
                        //System.out.println("查询成功"+list.get(0).room_id);
                        listview.adapter = ClassAdapter(this@ClassPage1,list,username)}

                }}}

        )


    }
}
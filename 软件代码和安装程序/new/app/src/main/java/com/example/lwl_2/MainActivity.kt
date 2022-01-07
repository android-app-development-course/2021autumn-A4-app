package com.example.lwl_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import cn.bmob.v3.Bmob
import cn.bmob.v3.listener.SaveListener
import com.example.lwl_2.entity.Room
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import cn.bmob.v3.exception.BmobException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("开始工作。。。。")
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {

            /*println("进来了。。。。。")
            Thread(Runnable {
                val sql = "SELECT * FROM user_info"
                mysqlConnection(sql)
            }).start()
             */

            Bmob.initialize(this, "8fdad39ac6d95c7ab098b496126324bd")
            val room: Room = Room()
            room.room_id = 1
            room.room_name = "自习室"
            room.room_type = "多人自习室"
            room.all = 10
            room.size = 4
            room.username="123"
            room.room_info = "2021没几天了！"
            room.save(object : SaveListener<String>() {
                override fun done(objectId: String, e: BmobException) {
                    if (e == null) {
                        println("创建数据成功：" + objectId)
                    } else {
                        Log.i("bmob", "失败：" + e.message + "," + e.errorCode)
                    }
                }
            })
        }

        /**
         * 连接数据库

        fun mysqlConnection(sql:String) {
        var cn: Connection
        try {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver")
        //建立连接
        cn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/lwl",
        "root", "123456")
        val ps = cn.createStatement()
        val resultSet = ps!!.executeQuery(sql)
        println("数据库连接成功！")
        while (resultSet.next()) {
        println("数据库连接成功。。。。。。。。。。！")
        Log.d("mysqlConnection: " , resultSet.getString("user_id") +
        resultSet.getString("user_sex") +
        resultSet.getString("user_name")+resultSet.getString("learn_time"))
        }
        if (ps != null) {
        ps!!.close()
        }
        if (cn != null) {
        cn.close()
        }
        } catch (e: ClassNotFoundException) {
        println("数据库连接失败.....")
        e.printStackTrace()
        } catch (e: SQLException) {
        println("数据库连接....失败.....")
        e.printStackTrace()
        }
         */


    }


}


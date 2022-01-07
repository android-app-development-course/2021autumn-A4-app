package com.example.lwl_2
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import cn.bmob.v3.Bmob
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.BmobUser
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.bmob.v3.listener.LogInListener
import cn.bmob.v3.listener.SaveListener
import com.example.lwl_2.entity.User
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.internal.userAgent
import java.sql.*

class Login : AppCompatActivity() {
    private var name:String = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = applicationContext
        setContentView(R.layout.activity_login)
        val username:EditText = findViewById(R.id.username)
        val pwd:EditText = findViewById(R.id.pwd)
        val register:Button = findViewById(R.id.register_button)
        val login: Button = findViewById(R.id.login_button)
        Bmob.initialize(this, "8fdad39ac6d95c7ab098b496126324bd")
        login.setOnClickListener {
            var skip = false
            if (username.toString().isNotEmpty() and pwd.toString().isNotEmpty())//输入信息非空
            {
                name = username.text.toString()
                val pwd_str:String = pwd.text.toString()
                val username_str:String = username.text.toString()
                BmobUser.loginByAccount(username_str,pwd_str,object :
                    LogInListener<User>(){
                    override fun done(u: User?, e: BmobException?) {
                        if (e ==null){
                            //System.out.println("登录成功")
                            //startActivity(Intent(context,HeadPage::class.java))
                            transform()
                        }
                        else{
                            System.out.println("登录失败")
                            Toast.makeText(context,"登录失败！",Toast.LENGTH_LONG).show()
                        }
                    }

                })
                //列值查询
//                val arr:BmobQuery<User> = BmobQuery<User>()
//                arr.addWhereEqualTo("username", username_str)
//                arr.findObjects(object :FindListener<User>()
//                {
//
//                })



            }
            if(skip)
            {
                val intent = Intent(this, HeadPage::class.java)
                startActivity(intent)
            }
        }

        register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }
    private fun transform() {
        val intent = Intent(this, HeadPage::class.java)
        intent.putExtra("user_id","$name")
        startActivity(intent)
    }



}
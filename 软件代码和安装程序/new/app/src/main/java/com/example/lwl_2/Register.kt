package com.example.lwl_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import cn.bmob.v3.BmobQuery
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.FindListener
import cn.bmob.v3.listener.SaveListener
import com.example.lwl_2.entity.User

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = applicationContext
        setContentView(R.layout.activity_register)
        val add_username:EditText= findViewById(R.id.add_username)
        val add_pwd:EditText = findViewById(R.id.add_pwd)
        val confirm:EditText = findViewById(R.id.confirm_pwd)
        val register:Button = findViewById(R.id.register_button)
        register.setOnClickListener {
            //首先看用户名是否存在
//            val username_txt:String = add_username.text.toString()
//            val pwd_txt:String = add_pwd.text.toString()
//            val confirm:String =
            if(!add_username.text.toString().isNotEmpty())//用户名为空
            {
                Toast.makeText(this,"用户名不能为空！",Toast.LENGTH_SHORT).show()
            }
            else if(!add_pwd.text.toString().isNotEmpty() || !confirm.text.toString().isNotEmpty())
            {
                //输入密码有一个为空
                Toast.makeText(this,"密码不能为空！",Toast.LENGTH_SHORT).show()
            }
            else if(add_pwd.text.toString()!=confirm.text.toString())
            {
                //输入密码有一个为空
                Toast.makeText(this,"输入密码不一致！",Toast.LENGTH_SHORT).show()
            }
            else{
                var q:BmobQuery<User> = BmobQuery()
                q.addWhereEqualTo("username",add_username.text.toString())//查询用户名是否存在
                q.findObjects(object :FindListener<User>(){
                    override fun done(u: MutableList<User>?, e: BmobException?) {
                        if (e==null)
                        {
                            System.out.println("用户已存在")
                        }else{
                            System.out.println("用户不存在")
                        }
                    }


                })
                //如果用户不存在则创建用户
                val user = User()
                user.setPassword(add_pwd.text.toString())
                user.setUsername(add_username.text.toString())
                user.signUp(object :SaveListener<User>(){
                    override fun done(u: User?, e: BmobException?) {
                        if (e == null) {
                            Toast.makeText(Login(),"注册成功！",Toast.LENGTH_SHORT).show()
                            System.out.println("注册成功")
                            startActivity(Intent(context,HeadPage::class.java))
                        } else {
                            Toast.makeText(context,"注册成功！",Toast.LENGTH_SHORT).show()
                            startActivity(Intent(context,Login::class.java))
                            System.out.println("注册失败")
                        }}
                    })

//                val intent = Intent(this, Login::class.java)
//                startActivity(intent)
                }
        }
    }
}
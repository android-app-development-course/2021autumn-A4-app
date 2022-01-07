package com.example.lwl_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Msg(val content:String,val type:Int){
    companion object{
        const val type_receive = 0
        const val type_send = 1
    }
}

class MsgAdapter(val msgList:List<Msg>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class LeftViewHolder(view: View):RecyclerView.ViewHolder(view){
        val leftMsg:TextView = view.findViewById(R.id.leftMsg)
    }
    inner class RightViewHolder(view: View):RecyclerView.ViewHolder(view){
        val rightMsg:TextView = view.findViewById(R.id.rightMsg)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if(viewType==Msg.type_receive){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,parent,false)
        LeftViewHolder(view)
    }else{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,parent,false)
        RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder){
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }
    override fun getItemCount() = msgList.size
}

class Chat : AppCompatActivity() ,View.OnClickListener{
    private val msgList = ArrayList<Msg>()
    val msg1:Msg= Msg("你好，明天有空吗",0)
    val msg2:Msg= Msg("在吗",0)

    private var adapter:MsgAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        val recyclerView:RecyclerView = findViewById(R.id.recycleView)
        initMsg()
        val send:Button = findViewById(R.id.send)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val num= intent.getStringExtra("num")?.toInt()
        if(num==1){
            msgList.add(msg1)
        }
        else
            msgList.add(msg2)

        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        send.setOnClickListener(this)
        val chat_back_button:ImageButton = findViewById(R.id.friend_mes_back_button)
        chat_back_button.setOnClickListener {
            finish()
        }
    }
    override fun onClick(v: View?){
        val send:Button = findViewById(R.id.send)
        val inputText:EditText = findViewById(R.id.inputText)
        when(v){

            send->{
                val recyclerView:RecyclerView = findViewById(R.id.recycleView)
                val content = inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg = Msg(content,Msg.type_send)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size-1)
                    recyclerView.scrollToPosition(msgList.size-1)
                    inputText.setText("")
                }
            }
        }
    }
    private fun initMsg(){
        val msg1 = Msg("hello",Msg.type_receive)
        msgList.add(msg1)
        val msg2 = Msg("hi!",Msg.type_send)
        msgList.add(msg2)
    }
}
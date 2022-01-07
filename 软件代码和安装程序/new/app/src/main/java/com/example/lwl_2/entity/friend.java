package com.example.lwl_2.entity;

import cn.bmob.v3.BmobObject;

public class friend extends BmobObject {
    private String user1 ;
    public friend setuser1(String u1){
        this.user1=u1;
        return this;
    }

    public String getuser1(){
        return user1;
    }

    private String user2 ;
    public friend setuser2(String u2){
        this.user2=u2;
        return this;
    }

    public String getuser2(){
        return user2;
    }

}
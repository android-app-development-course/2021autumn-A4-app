package com.example.lwl_2.entity;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    //自定 学习时长 分钟
    private Integer learn_time = 0;

    public User setLearn_time(Integer t){
        this.learn_time=t;
        return this;
    }

    public Integer getLearn_time(){
        return learn_time;
    }
}

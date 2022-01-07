package com.example.lwl_2.entity;


import cn.bmob.v3.BmobObject;


public class Room extends BmobObject {

    private Number room_id ;
    private String room_type;
    private String room_name;
    private String room_info;
    private String username;
    private int size;
    private int all;

    public Number getRoom_id()
    {
        return this.room_id;
    }
    public void setRoom_id(Number room_id)
    {
        this.room_id = room_id;
    }

    public String getRoom_type()
    {
        return this.room_type;
    }
    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_name() {
        return room_name;
    }
    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public int getAll() {
        return all;
    }
    public void setAll(int all) {
        this.all = all;
    }

    public String getRoom_info() {
        return room_info;
    }
    public void setRoom_info(String room_info) {
        this.room_info = room_info;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

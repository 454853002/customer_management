package com.fuyu.entity;

import java.sql.Date;

public class User {
    private int  id;   //id
    private String name;  //姓名
    private String  sex;  //性别
    private String  birth;  //出生日期
    private String  phone;   //电话号码
    private String  note;  //备注

    public User() {
    }

    public User(int id, String name, String sex, String birth, String phone, String note) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.phone = phone;
        this.note = note;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

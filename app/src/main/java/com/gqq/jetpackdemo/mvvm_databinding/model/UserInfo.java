package com.gqq.jetpackdemo.mvvm_databinding.model;

import androidx.databinding.ObservableField;

public class UserInfo {

    // 被观察者的属性(必须是public)
    // 1. 写法1
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> pwd = new ObservableField<>();

    // 2 常规写法
//    private String name;
//    private String pwd;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
}

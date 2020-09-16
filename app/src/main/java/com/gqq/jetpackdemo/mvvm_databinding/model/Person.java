package com.gqq.jetpackdemo.mvvm_databinding.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

/**
 * 单向绑定第一种方法
 */
//public class Person extends BaseObservable {
//
//    private String name;
//    private String pwd;
//
//    @Bindable
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//        notifyPropertyChanged(BR.name);
//    }
//
//    @Bindable
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//        notifyPropertyChanged(BR.pwd);
//    }
//}

/**
 * 单向绑定第二种方法
 */
public class Person {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> pwd = new ObservableField<>();
}

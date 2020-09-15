package com.gqq.jetpackdemo.mvvm_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import com.gqq.jetpackdemo.R;
import com.gqq.jetpackdemo.databinding.ActivityBindBinding;
import com.gqq.jetpackdemo.mvvm_databinding.viewmodel.UserViewModel;

public class BindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. 先进行rebuild；2. 书写代码绑定
        ActivityBindBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind);
        new UserViewModel(viewDataBinding);
    }
}

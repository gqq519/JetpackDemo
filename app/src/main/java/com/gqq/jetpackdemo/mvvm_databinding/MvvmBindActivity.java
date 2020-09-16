package com.gqq.jetpackdemo.mvvm_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import com.gqq.jetpackdemo.R;
import com.gqq.jetpackdemo.databinding.ActivityBindMvvmBinding;
import com.gqq.jetpackdemo.mvvm_databinding.viewmodel.UserViewModel;

public class MvvmBindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindMvvmBinding bindMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_mvvm);
        new UserViewModel(bindMvvmBinding);
    }
}

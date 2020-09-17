package com.gqq.jetpackdemo.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gqq.jetpackdemo.R;

// 生命周期被观察者
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 绑定生命周期的监听
        getLifecycle().addObserver(new CustomLifeCycle());
    }

    public void startRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
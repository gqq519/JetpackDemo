package com.gqq.jetpackdemo.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gqq.jetpackdemo.R;

// 生命周期被观察者
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 绑定生命周期的监听
        getLifecycle().addObserver(new CustomLifeCycle());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
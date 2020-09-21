package com.gqq.jetpackdemo.livedata;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.gqq.jetpackdemo.R;

public class Live2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        // Activity销毁的话，监听也会相应的移除，避免崩溃
        finish();

        LiveViewModel.getInstances().getLiveDataName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                ((TextView)findViewById(R.id.tv_name)).setText(s);
            }
        });

        // 测试更改数据
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LiveViewModel.getInstances().getLiveDataName().setValue("返回的数据");
            }
        }, 1500);
    }
}
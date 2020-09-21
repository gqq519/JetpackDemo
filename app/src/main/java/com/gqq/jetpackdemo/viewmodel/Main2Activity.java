package com.gqq.jetpackdemo.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gqq.jetpackdemo.R;
import com.gqq.jetpackdemo.mvvm_databinding.model.UserInfo;

/**
 * ViewModel: https://developer.android.com/topic/libraries/architecture/viewmodel?hl=zh-cn#java
 * ViewModel 类旨在以注重生命周期的方式存储和管理界面相关的数据。ViewModel 类让数据可在发生屏幕旋转等配置更改后继续留存。
 *
 *
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Main2ViewModel main2ViewModel;
    private TextView tvUser;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        tvUser = findViewById(R.id.tv_user);
        button = findViewById(R.id.btn);
        button.setOnClickListener(this);

        // 使用ViewModel
        main2ViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(Main2ViewModel.class);

        main2ViewModel.getUsers().observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                // update UI
                tvUser.setText(userInfo.name.get() + "\n" + userInfo.pwd.get());
            }
        });
    }

    @Override
    public void onClick(View v) {
        // 操作
        main2ViewModel.updateUser();
    }
}

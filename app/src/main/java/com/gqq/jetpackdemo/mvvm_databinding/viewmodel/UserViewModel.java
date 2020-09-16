package com.gqq.jetpackdemo.mvvm_databinding.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.gqq.jetpackdemo.databinding.ActivityBindBinding;
import com.gqq.jetpackdemo.databinding.ActivityBindMvvmBinding;
import com.gqq.jetpackdemo.mvvm_databinding.model.UserInfo;

public class UserViewModel {

    public static final String TAG = "TAG";

    public UserInfo userInfo;

    public UserViewModel(ActivityBindMvvmBinding viewDataBinding) {
        userInfo = new UserInfo();
        // 将View与ViewModel进行绑定，通过DataBinding工具
        viewDataBinding.setUserViewModel(this);
    }

    public TextWatcher nameInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // view层接受用户输入，手动更改Model的数据，model->view
            userInfo.name.set(String.valueOf(s));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public TextWatcher pwdInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // view层接受用户输入，手动更改Model的数据，model->view
            userInfo.pwd.set(String.valueOf(s));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public View.OnClickListener onClickConfirm = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userInfo.name.set("hhh"); // 双向绑定，model->View
            Log.i(TAG, "onClick: name=" + userInfo.name.get() +",pwd=" + userInfo.pwd.get());
        }
    };
}

package com.gqq.jetpackdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gqq.jetpackdemo.mvvm_databinding.model.UserInfo;

// 继承自ViewModel
public class Main2ViewModel extends ViewModel {

    private MutableLiveData<UserInfo> user;

    public LiveData<UserInfo> getUsers() {
        if (user == null) {
            user = new MutableLiveData<>();
            loadUser();
        }
        return user;
    }

    private void loadUser() {
        // fetch user
        UserInfo userInfo = new UserInfo();
        userInfo.name.set("gqq");
        userInfo.pwd.set("pwd:123");
        user.setValue(userInfo);
    }

    public void updateUser() {
        UserInfo userInfo = user.getValue();
        userInfo.name.set("hei");
        userInfo.pwd.set("ha");
        user.setValue(userInfo);
    }
}

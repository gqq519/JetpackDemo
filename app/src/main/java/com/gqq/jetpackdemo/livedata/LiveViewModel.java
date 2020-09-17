package com.gqq.jetpackdemo.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by gqq on 2020/9/17.
 */
public class LiveViewModel {

    private static LiveViewModel liveViewModel;

    public static LiveViewModel getInstances() {
        if (liveViewModel == null) {
            synchronized (LiveViewModel.class) {
                if (liveViewModel == null) {
                    liveViewModel = new LiveViewModel();
                }
            }
        }
        return liveViewModel;
    }

    // 创建LiveData：LiveData是一个抽象类，一般我们使用MutableLiveData子类
    private MutableLiveData<String> name;

    public LiveViewModel() {
        name = new MutableLiveData<>();
    }

    public MutableLiveData<String> getLiveDataName() {
        return name;
    }
}

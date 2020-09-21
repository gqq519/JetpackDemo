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

    /**
     * 创建LiveData：LiveData是一个抽象类，一般我们使用MutableLiveData子类
     *
     * 请确保用于更新界面的 LiveData 对象存储在 ViewModel 对象中，而不是将其存储在 Activity 或 Fragment 中，原因如下：
     *
     * 1、避免 Activity 和 Fragment 过于庞大。现在，这些界面控制器负责显示数据，但不负责存储数据状态。
     * 2、将 LiveData 实例与特定的 Activity 或 Fragment 实例分离开，并使 LiveData 对象在配置更改后继续存在。
     *
     */
    private MutableLiveData<String> name;

    public LiveViewModel() {
        name = new MutableLiveData<>();
    }

    public MutableLiveData<String> getLiveDataName() {
        return name;
    }
}

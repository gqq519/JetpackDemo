package com.gqq.jetpackdemo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 1、继承自LifecycleObserver
 * 2、@OnLifecycleEvent(Lifecycle.Event.ON_START)监听相应的方法
 *
 * 使用Lifecycle的目的：
 * 1、解决代码入侵：在很多Activity的生命周期中需要统一做的事情，比如用接口也可以实现，但是会有代码入侵的风险(Activity中有接口相关的调用)
 * 2、解决内存泄漏：使用接口或者其他方式，有可能需要传递Activity的context，处理不当，可能会内存血泄漏
 * 3、解决统一管理
 */
public class CustomLifeCycle implements LifecycleObserver {

    private static final String TAG = CustomLifeCycle.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate() {
        Log.w(TAG, "onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {
        Log.w(TAG, "onStart: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {
        Log.w(TAG, "onStop: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause() {
        Log.w(TAG, "onPause: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume() {
        Log.w(TAG, "onResume: ");
    }

}

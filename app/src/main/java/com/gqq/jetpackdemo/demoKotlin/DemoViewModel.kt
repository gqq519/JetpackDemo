package com.gqq.jetpackdemo.demoKotlin

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * Created by gqq on 2020/9/23.
 */
class DemoViewModel(application: Application) : AndroidViewModel(application) {

    // 定义环境
    val context: Context = application

    // 定义一个懒加载的phoneInfo
    val phoneInfo by lazy {
        MutableLiveData<String>()
    }

    init {
        phoneInfo.value = ""
    }

    // 累加数据
    fun appendNumber() {
        phoneInfo.value = phoneInfo.value + (Math.random() * 10).toInt()
    }


    // 递减数据
    fun backspaceNumber() {
        // ? phoneInfo可能为空，会报错，规避一下
        val len: Int = phoneInfo.value?.length ?: 0
        if (len > 0) {
            // ？同样的问题
            phoneInfo.value = phoneInfo.value?.subSequence(0, len - 1).toString()
        }
    }

    // 操作
    fun handleIntent() {
        val intent: Intent = Intent()
        intent.action = Intent.ACTION_DIAL
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.data = Uri.parse("tel:" + phoneInfo.value)
        context.startActivity(intent)
    }

}

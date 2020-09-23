package com.gqq.jetpackdemo.demoKotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by gqq on 2020/9/23.
 */
abstract class BaseActivity : AppCompatActivity(), ICallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewAction()
    }

    abstract fun initViewAction()

    abstract fun getLayoutRes() : Int


}
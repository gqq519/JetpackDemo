package com.gqq.jetpackdemo.demoKotlin

import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gqq.jetpackdemo.R
import com.gqq.jetpackdemo.databinding.ActivityDemoBinding

/**
 * Created by gqq on 2020/9/23.
 */
class DemoActivity : BaseActivity() {

    companion object {
        private const val TAG = "DemoActivity"
    }

    private lateinit var binding : ActivityDemoBinding
    lateinit var viewModel: DemoViewModel

    override fun initViewAction() {
        binding = DataBindingUtil.setContentView<ActivityDemoBinding>(this, getLayoutRes())
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(DemoViewModel::class.java)

        binding.model = viewModel
        binding.lifecycleOwner = this

    }

    override fun getLayoutRes() = R.layout.activity_demo

    override fun testCallback() {
        Log.i(TAG, "testCallback: ")
    }

}
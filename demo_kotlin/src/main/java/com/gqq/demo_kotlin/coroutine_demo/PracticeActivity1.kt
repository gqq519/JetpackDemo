package com.gqq.demo_kotlin.coroutine_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gqq.demo_kotlin.R
import kotlinx.android.synthetic.main.activity_practice1.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 扔物线协程讲解视频的实例Demo
 *
 */

class PracticeActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice1)


        GlobalScope.launch(Dispatchers.Main) {
            val data = getData();
            val processData = processData(data);
            updateUI(processData);
        }
        // 练习内容：用协程让上面 ↑ 这两行放在后台执行，然后把代码截图贴到腾讯课堂的作业里
    }

    // 耗时函数 1
    private suspend fun getData(): String {
        // 假设这个函数比较耗时，需要放在后台
        return withContext(Dispatchers.IO) {
            "hen_coder"
        }
    }

    // 耗时函数 2
    private suspend fun processData(data: String): String {
        // 假设这个函数也比较耗时，需要放在后台
        return withContext(Dispatchers.IO) {
            data.split("_") // 把 "hen_coder" 拆成 ["hen", "coder"]
                    .map { it.capitalize() } // 把 ["hen", "coder"] 改成 ["Hen", "Coder"]
                    .reduce { acc, s -> acc + s } // 把 ["Hen", "Coder"] 改成 "HenCoder"
        }
    }

    private fun updateUI(processedData: String) {
        textView.text = processedData
    }
}
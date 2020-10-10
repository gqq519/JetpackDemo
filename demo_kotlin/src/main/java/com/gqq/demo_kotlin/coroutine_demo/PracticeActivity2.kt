package com.gqq.demo_kotlin.coroutine_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gqq.demo_kotlin.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_practice2.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PracticeActivity2 : AppCompatActivity() {

    val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice2)


        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(Api::class.java)

        // 1. 直接使用Retrofit
//        api.listRepos("gqq519")
//                .enqueue(object : Callback<List<Repo>> {
//                    override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
//                        textView.text = t.message
//                    }
//
//                    override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
//                        textView.text = response.body()?.get(0)?.full_name
//                    }
//
//                })

        // 借助RxJava合并请求
//        Single.zip<List<Repo>, List<Repo>, String>(
//                api.listReposRx("gqq519"),
//                api.listReposRx("google"),
//                BiFunction { repos1, repos2 -> "${repos1[0].full_name} -- ${repos2[0].full_name}" }
//        ).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : SingleObserver<String> {
//                    override fun onSuccess(t: String?) {
//                        textView.text = t
//                    }
//
//                    override fun onSubscribe(d: Disposable?) {
//                        disposable.add(d)
//                    }
//
//                    override fun onError(e: Throwable?) {
//                        textView.text = e?.message
//                    }
//
//                })


        // 2. 利用协程
//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val repos: List<Repo> = api.listReposKt("gqq519")
//                textView.text = repos[0].full_name
//            } catch (e: Exception) {
//                textView.text = e.message
//            }
//        }

        // 协程合并请求
//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val repos1 = async { api.listReposKt("gqq519") }
//                val repos2 = async { api.listReposKt("google") }
//                textView.text = "${repos1.await()[0].full_name} -- ${repos2.await()[0].full_name}"
//            } catch (e: Exception) {
//                textView.text = e.message
//            }
//        }

        /**
         * 协程请求的取消
         * GlobalScope.launch 返回值Job.cancel()
         * lifecycleScope 生命周期绑定的scope
         */
//        val job = GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val repos1 = async { api.listReposKt("gqq519") }
//                val repos2 = async { api.listReposKt("google") }
//                textView.text = "${repos1.await()[0].full_name} -- ${repos2.await()[0].full_name}"
//            } catch (e: Exception) {
//                textView.text = e.message
//            }
//        }
//      取消
//        job.cancel()

        // lifecycleScope
        lifecycleScope.launch {
            try {
                val repos1 = async { api.listReposKt("gqq519") }
                val repos2 = async { api.listReposKt("google") }
                textView.text = "${repos1.await()[0].full_name} -- ${repos2.await()[0].full_name}"
            } catch (e: Exception) {
                textView.text = e.message
            }
        }


    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
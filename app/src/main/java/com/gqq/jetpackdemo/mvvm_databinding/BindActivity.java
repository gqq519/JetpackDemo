package com.gqq.jetpackdemo.mvvm_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.gqq.jetpackdemo.R;
import com.gqq.jetpackdemo.databinding.ActivityBindBinding;
import com.gqq.jetpackdemo.mvvm_databinding.model.Person;

/**
 * DataBinding：一种工具，主要进行View与Model的（双向）绑定，并不是MVVM特有的，在MVC、MVP中也可以使用。
 * 1 在build.gradle 中添加databinding的支持
 *     dataBinding {
 *         enabled = true
 *     }
 * 2 定义Model类和View文件
 * 3 在View中使用Model类的属性或方法
 *
 *
 * MVVM：MVVM是一种架构设计思想，Model、View、ViewModel
 * 优点：
 * 1 降低耦合：一个ViewModel可以绑定不用的View，Model变化时View可以不变
 * 2 可重用性：不同的View可以复用同一个ViewModel的逻辑
 */
public class BindActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private Person person = new Person();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * DataBinding 实践
         * 1. build.gradle、View、Model见代码
         * 2. rebuild & 编写绑定代码
         */

        // ActivityBindBinding rebuild之后生成的绑定类，通过绑定类设置View
        ActivityBindBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind);

        /**
         * 1、单向绑定的第一种方式：Model->View
         */
//        person.setName("gqq");
//        person.setPwd("123");
//        viewDataBinding.setPerson(person);
//
//        Log.w(TAG, person.getName() +"," + person.getPwd());
//
//        // 数据的刷新：Model更改之后需要在View上进行数据的刷新
//        // 修改Model：继承自BaseObservable、get方法加@Bindable、对应的设置方法notifyPropertyChanged(BR.name);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                person.setName("更新后的gqq");
//                person.setPwd("更新后的123");
//                Log.w(TAG, person.getName() +"," + person.getPwd());
//            }
//        }, 2000);

        /**
         * 2、单向绑定的第二种方式：Model->View
         * Model 中定义属性的方式更改为ObservableField
         */
//        person.name.set("gqq");
//        person.pwd.set("123");
//        viewDataBinding.setPerson(person);
//
//        Log.w(TAG, person.name.get() +"," + person.pwd.get());
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                person.name.set("更新后的gqq");
//                person.pwd.set("更新后的123");
//                Log.w(TAG, person.name.get() +"," + person.pwd.get());
//            }
//        }, 2000);

        /**
         * 3、双向绑定(View->Model, Model->View)
         * View->Model 需要在布局中修改：@={person.name},加一个等号
         */
        person.name.set("gqq");
        person.pwd.set("123");
        viewDataBinding.setPerson(person);

        Log.w(TAG, person.name.get() +"," + person.pwd.get());

        // 15秒内手动输入数据，更改EditText的数据
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.w(TAG, person.name.get() +"," + person.pwd.get());
            }
        }, 15000);
    }
}

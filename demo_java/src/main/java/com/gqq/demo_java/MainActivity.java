package com.gqq.demo_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.gqq.demo_java.adapters.MainViewPagerAdapter;
import com.gqq.demo_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private int[] tabText = {R.string.main_tab_mine, R.string.main_tab_all};
    private int[] tabDrawable = {R.drawable.selector_tab_mine, R.drawable.selector_tab_plant_list};
    private ViewPager2 viewpager2;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewpager2 = binding.viewpager2;
        tablayout = binding.tablayout;

        initViewPager2();
    }

    private void initViewPager2() {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(this);
        viewpager2.setAdapter(adapter);

        new TabLayoutMediator(tablayout, viewpager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                Log.i(TAG, "onConfigureTab: " + position);
                tab.setText(tabText[position]);
                tab.setIcon(tabDrawable[position]);
            }
        }).attach();
    }
}

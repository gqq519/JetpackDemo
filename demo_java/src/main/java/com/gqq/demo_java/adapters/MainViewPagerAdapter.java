package com.gqq.demo_java.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.gqq.demo_java.GardenFragment;
import com.gqq.demo_java.PlantsFragment;

/**
 * Created by gqq on 2020/9/21.
 */
public class MainViewPagerAdapter extends FragmentStateAdapter {

    public MainViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return GardenFragment.newInstances();
            case 1:
                return PlantsFragment.newInstances();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

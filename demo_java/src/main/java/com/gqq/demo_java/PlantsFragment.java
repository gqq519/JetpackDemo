package com.gqq.demo_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gqq.demo_java.databinding.FragmentPlantsBinding;

/**
 * Created by gqq on 2020/9/21.
 */
public class PlantsFragment extends Fragment {

    public static Fragment newInstances() {
        PlantsFragment plantsFragment = new PlantsFragment();
        Bundle bundle = new Bundle();
        plantsFragment.setArguments(bundle);
        return plantsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPlantsBinding binding = FragmentPlantsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}

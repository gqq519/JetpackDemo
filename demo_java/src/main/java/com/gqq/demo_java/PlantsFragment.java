package com.gqq.demo_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

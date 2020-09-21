package com.gqq.demo_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gqq.demo_java.databinding.FragmentGardenBinding;

/**
 * Created by gqq on 2020/9/21.
 */
public class GardenFragment extends Fragment {

    public static Fragment newInstances() {
        GardenFragment gardenFragment = new GardenFragment();
        Bundle bundle = new Bundle();
        gardenFragment.setArguments(bundle);
        return gardenFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentGardenBinding binding = FragmentGardenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}

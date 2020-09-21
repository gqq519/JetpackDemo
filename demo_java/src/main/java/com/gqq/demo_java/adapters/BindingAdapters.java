package com.gqq.demo_java.adapters;

/**
 * Created by gqq on 2020/9/21.
 */

import android.view.View;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter("isGone")
    public static void bindIsGone(View view, boolean isGone) {
        view.setVisibility(isGone ? View.GONE : View.VISIBLE);
    }
}

package com.gqq.demo_java.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gqq on 2020/9/22.
 */
public class UnSplashSearchResponse {

    @SerializedName("results")
    public List<UnSplashPhoto> results;
    @SerializedName("total_pages")
    public int totalPages;

}

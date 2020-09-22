package com.gqq.demo_java.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gqq on 2020/9/22.
 */
public class UnSplashPhoto {

    @SerializedName("id")
    public String id;
    @SerializedName("urls")
    public UnSplashPhotoUrls urls;
    @SerializedName("user")
    public UnSplashUser user;

}

package com.gqq.demo_java.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gqq on 2020/9/22.
 */
class UnSplashUser {

    @SerializedName("name")
    String name;
    @SerializedName("username")
    String username;


    public String attributionUrl() {
        return String.format("https://unsplash.com/%s?utm_source=sunflower&utm_medium=referral", username);
    }
}
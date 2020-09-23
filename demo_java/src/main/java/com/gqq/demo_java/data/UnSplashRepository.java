package com.gqq.demo_java.data;

import androidx.paging.PagingSource;

import com.gqq.demo_java.api.ApiModule;
import com.gqq.demo_java.api.UnSplashService;

/**
 * Created by gqq on 2020/9/22.
 */
public class UnSplashRepository {

    private UnSplashService unSplashService;

    public UnSplashRepository() {
        this.unSplashService = ApiModule.createUnSplashService();
    }

    public UnSplashSearchResponse getSearchResultStream(String query) {
        return null;
    }
}

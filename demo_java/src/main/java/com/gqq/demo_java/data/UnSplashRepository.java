package com.gqq.demo_java.data;

import androidx.paging.PagedList;
import androidx.paging.PagingData;

import com.gqq.demo_java.api.UnSplashService;

/**
 * Created by gqq on 2020/9/22.
 */
public class UnSplashRepository {

    private UnSplashService unSplashService;

    public UnSplashRepository(UnSplashService unSplashService) {
        this.unSplashService = unSplashService;
    }

    public void getSearchResultStream() {

    }
}

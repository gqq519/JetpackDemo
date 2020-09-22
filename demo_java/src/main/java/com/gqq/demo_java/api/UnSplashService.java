package com.gqq.demo_java.api;

import com.gqq.demo_java.data.UnSplashSearchResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gqq on 2020/9/22.
 */
public interface UnSplashService {

    @GET("search/photos")
    UnSplashSearchResponse searchPhotos(@Query("query") String query,
                                        @Query("page") int page,
                                        @Query("per_page") int perPage,
                                        @Query("client_id") String clientId);
}

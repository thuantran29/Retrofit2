package com.trannguyentanthuan2903.retrofit2.api;

import com.trannguyentanthuan2903.retrofit2.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 12/28/2017.
 */
//String url ="https://api.500px.com/v1/photos?feature=popular&page=1&consumer_key=API_KEY";
public interface ApiInterface {

    @GET("photos")
    Call<Example> getPhotos(@Query("feature") String feature,
                            @Query("page") int page,
                            @Query("consumer_key") String apiKey);

    @GET("photos?feature=popular&page=1&")
    Call<Example> getPhotoResponse(@Query("consumer_key") String apiKey);
}
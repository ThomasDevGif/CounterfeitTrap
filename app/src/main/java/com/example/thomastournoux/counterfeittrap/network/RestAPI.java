package com.example.thomastournoux.counterfeittrap.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestAPI {

    @GET("org.conterfeittrap.model.Rolex")
    Call<ResponseBody> getAllRolex();

    @POST("org.conterfeittrap.model.Rolex")
    Call<ResponseBody> createRolex(@Body RequestBody rolex);

}

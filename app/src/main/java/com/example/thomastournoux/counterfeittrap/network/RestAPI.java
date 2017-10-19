package com.example.thomastournoux.counterfeittrap.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {

    @GET("org.conterfeittrap.model.Rolex")
    Call<ResponseBody> getAllRolex();

}

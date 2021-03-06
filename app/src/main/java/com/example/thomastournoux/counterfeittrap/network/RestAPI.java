package com.example.thomastournoux.counterfeittrap.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestAPI {

    // Rolex
    @GET("org.conterfeittrap.model.Rolex")
    Call<ResponseBody> getAllRolex();

    @POST("org.conterfeittrap.model.Rolex")
    Call<ResponseBody> createRolex(@Body RequestBody rolex);

    // Trader
    @GET("org.conterfeittrap.model.Trader")
    Call<ResponseBody> getAllTraders();

    @GET("org.conterfeittrap.model.Trader/{id}")
    Call<ResponseBody> getTraderById(@Path("id") String traderId);

    // Trade
    @GET("org.conterfeittrap.model.Trade")
    Call<ResponseBody> getAllTrades();

}

package com.example.thomastournoux.counterfeittrap.network;

import android.content.Context;

import com.example.thomastournoux.counterfeittrap.R;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RestConnectorBuilder {

    private static final int TIMEOUT = 15;

    public static RestAPI build(Context context) {
        RestAPI restAdapter;

        final String ipAddress = "http://148.100.98.229:8080";

        String serverAddress =  context.getResources().getString(R.string.http)
                + context.getResources().getString(R.string.ip) + ":"
                + context.getResources().getString(R.string.port) + "/";

        OkHttpClient client = null;
        client = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return ipAddress.compareTo(hostname) == 0;
                    }
                })
                .build();

        /* Create retrofit instance for this server address */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(serverAddress)
                .client(client)
                .build();

        // prepare call in Retrofit 2.0
        restAdapter = retrofit.create(RestAPI.class);

        return restAdapter;
    }
}

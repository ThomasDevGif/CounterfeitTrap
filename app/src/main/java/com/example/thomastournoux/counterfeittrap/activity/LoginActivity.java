package com.example.thomastournoux.counterfeittrap.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.network.RestAPI;
import com.example.thomastournoux.counterfeittrap.network.RestConnectorBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.thomastournoux.counterfeittrap.network.RestCode.RESULT_CODE_OK;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkConnection();
    }

    /**
     * Check connection to blockchain vm
     */
    private void checkConnection() {
        RestAPI restAdapter = RestConnectorBuilder.build(getApplicationContext());
        Call<ResponseBody> call = restAdapter.getAllRolex();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == RESULT_CODE_OK) {
                    Intent intent = new Intent();
                    startActivity(intent);
                } else {
                    Log.e(TAG, "ERROR: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "ERROR: " + t.getMessage());
            }
        });
    }
}
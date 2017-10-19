package com.example.thomastournoux.counterfeittrap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.application.UserApplication;
import com.example.thomastournoux.counterfeittrap.network.RestAPI;
import com.example.thomastournoux.counterfeittrap.network.RestConnectorBuilder;
import com.example.thomastournoux.counterfeittrap.object.Trade;
import com.example.thomastournoux.counterfeittrap.util.Information;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.thomastournoux.counterfeittrap.network.RestCode.RESULT_CODE_OK;
import static com.example.thomastournoux.counterfeittrap.util.Information.ALERT;

public class TradeActivity extends AppCompatActivity {

    private Trade mTrade;
    private TextView mTradeRolex;
    private TextView mTradeNewOwner;
    private TextView mTradeId;
    private TextView mTradeDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Trade");
        initialize();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Init variables
     */
    private void initialize() {
        mTrade = UserApplication.getSelectedTrade();

        mTradeRolex = (TextView) findViewById(R.id.tv_trade_rolex);
        String stringRolex = mTrade.getRolex();
        String[] partsRolex = stringRolex.split("#");
        mTradeRolex.setText(partsRolex[1]);

        mTradeNewOwner = (TextView) findViewById(R.id.tv_trade_owner);
        mTradeNewOwner.setText(splitOwnerId());
//        mTradeNewOwner.setText(getResources().getString(R.string.loading));

        mTradeId = (TextView) findViewById(R.id.tv_trade_transactionId);
        mTradeId.setText(mTrade.getTransactionId());

        mTradeDate = (TextView) findViewById(R.id.tv_trade_date);
        mTradeDate.setText(mTrade.getTimestamp());
    }

    /**
     * Get trader by id
     * @param ownerId OwerId
     */
    private void getTradeNewOwner(String ownerId) {
        RestAPI restAdapter = RestConnectorBuilder.build(getApplicationContext());
        Call<ResponseBody> call = restAdapter.getTraderById(ownerId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == RESULT_CODE_OK) {
                    try {
                        Log.e("TAG", "Response: " + response.body().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    mTradeNewOwner.setText(splitOwnerId());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mTradeNewOwner.setText(splitOwnerId());
            }
        });
    }

    /**
     * Split String
     * @return OwerId
     */
    private String splitOwnerId() {
        String stringOwner = mTrade.getNewOwner();
        String[] partsOwner = stringOwner.split("#");
        return partsOwner[1];
    }
}

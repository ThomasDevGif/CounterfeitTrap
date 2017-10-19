package com.example.thomastournoux.counterfeittrap.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.adpater.RolexListAdapter;
import com.example.thomastournoux.counterfeittrap.network.RestAPI;
import com.example.thomastournoux.counterfeittrap.network.RestConnectorBuilder;
import com.example.thomastournoux.counterfeittrap.object.Rolex;
import com.example.thomastournoux.counterfeittrap.util.Information;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.thomastournoux.counterfeittrap.network.RestCode.RESULT_CODE_OK;
import static com.example.thomastournoux.counterfeittrap.util.Information.ALERT;

public class RolexFragment extends Fragment {

    private static final String TAG = "RolexFragment";
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFabAddRolex;

    public RolexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RolexFragment.
     */
    public static RolexFragment newInstance() {
        RolexFragment fragment = new RolexFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rolex, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        initialize();
        loadRolexList();
    }

    /**
     * Initialize variables
     */
    private void initialize() {
        // Progressbar
        mProgressBar = (ProgressBar) getActivity().findViewById(R.id.progressbar_rolex);
        // List
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.list_rolex);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        // ProgressBar
        mFabAddRolex = (FloatingActionButton) getActivity().findViewById(R.id.fab_rolex);
        mFabAddRolex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createRolex();
            }
        });
    }

    /**
     * Display the list of rolex
     */
    private void loadRolexList() {
        RestAPI restAdapter = RestConnectorBuilder.build(getContext());
        Call<ResponseBody> call = restAdapter.getAllRolex();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == RESULT_CODE_OK) {
                    createRolexList(response);
                } else {
                    Information.createSnackBar(getActivity(),
                            getResources().getString(R.string.error_connection),
                            ALERT, Snackbar.LENGTH_LONG, null, null);
                    Log.e(TAG, "ERROR: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Information.createSnackBar(getActivity(),
                        getResources().getString(R.string.error_connection),
                        ALERT, Snackbar.LENGTH_LONG, null, null);
                Log.e(TAG, "ERROR: " + t.getMessage());
            }
        });
    }

    /**
     * Convert response array to list of Rolex
     * @param response Response
     */
    private void createRolexList(Response<ResponseBody> response) {
        List<Rolex> rolexList = new ArrayList<>();
        Gson gson = new Gson();

        try {
            String json = response.body().string();
            Type collectionType = new TypeToken<List<Rolex>>(){}.getType();
            rolexList = gson.fromJson(json, collectionType);
        } catch (Exception e) {
            Log.e(TAG, "ERROR: " + e.getMessage());
        }

        mProgressBar.setVisibility(View.GONE);
        RecyclerView.Adapter mAdapter = new RolexListAdapter(getContext(), this, rolexList);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Create rolex on blockchain api
     */
    private void createRolex() {
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View dialogView = inflater.inflate(R.layout.dialog_create_rolex, null);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setIcon(getContext().getResources().getDrawable(R.drawable.ic_watch_black))
//                .setTitle(getContext().getResources().getString(R.string.add_rolex))
//                .setView(dialogView)
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // continue with delete
//                    }
//                })
//                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do nothing
//                    }
//                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show();
//
//        EditText editText = (EditText) dialogView.findViewById(R.id.brand);
    }
}

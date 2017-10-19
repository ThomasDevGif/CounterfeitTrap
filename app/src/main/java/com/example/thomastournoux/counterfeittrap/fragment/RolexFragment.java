package com.example.thomastournoux.counterfeittrap.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.adpater.RolexListAdapter;
import com.example.thomastournoux.counterfeittrap.object.Rolex;

import java.util.ArrayList;
import java.util.List;

public class RolexFragment extends Fragment {

    private RecyclerView mRecyclerView;

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
        // List
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.list_rolex);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * Display the list of rolex
     */
    private void loadRolexList() {
        List<Rolex> rolexList = new ArrayList<>();

        Rolex rolex = new Rolex();
        rolex.setRolexId("1");
        rolex.setSerialNumber("123456");

        Rolex rolex2 = new Rolex();
        rolex2.setRolexId("2");
        rolex2.setSerialNumber("987654");

        rolexList.add(rolex);
        rolexList.add(rolex2);

        RecyclerView.Adapter mAdapter = new RolexListAdapter(getContext(), rolexList);
        mRecyclerView.setAdapter(mAdapter);
    }

}

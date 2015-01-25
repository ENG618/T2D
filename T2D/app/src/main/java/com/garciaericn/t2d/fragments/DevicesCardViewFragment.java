package com.garciaericn.t2d.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garciaericn.t2d.R;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/20/15.
 */
public class DevicesCardViewFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public DevicesCardViewFragment() {
        // Required empty public constructor
    }

    public static DevicesCardViewFragment newInstance() {
        // Bundle parameters is necessary

        return new DevicesCardViewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get arguments
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_devices_list, container, false);

        // Obtain recycler view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.devices_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // Set layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);



        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        // Click events go here
    }

    public interface OnFragmentInteractionListener {
        // TODO: Add any methods here to communicate with activity
    }
}

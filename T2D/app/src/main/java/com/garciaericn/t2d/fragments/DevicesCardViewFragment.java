package com.garciaericn.t2d.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garciaericn.t2d.R;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/20/15.
 */
public class DevicesCardViewFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

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
        return inflater.inflate(R.layout.fragment_devices_list, container, false);
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

    public interface OnFragmentInteractionListener {
        // TODO: Add any methods here to communicate with activity
    }
}

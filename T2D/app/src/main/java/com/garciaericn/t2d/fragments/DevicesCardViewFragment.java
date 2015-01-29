package com.garciaericn.t2d.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.garciaericn.t2d.R;
import com.garciaericn.t2d.data.BatteryHelper;
import com.garciaericn.t2d.data.Device;
import com.garciaericn.t2d.data.DeviceAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/20/15.
 */
public class DevicesCardViewFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private BatteryHelper mBatteryHelper;
    Intent mBatteryStatus;

    private RecyclerView mRecyclerView;
    private DeviceAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Device> mDevices;

    public DevicesCardViewFragment() {
        // Required empty public constructor
        mDevices = new ArrayList<Device>();
    }

    public static DevicesCardViewFragment newInstance() {
        // Bundle parameters is necessary

        return new DevicesCardViewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get arguments
        getDevices();

        mBatteryHelper = new BatteryHelper(getActivity());

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        mBatteryStatus = getActivity().registerReceiver(null, intentFilter);

        // Update stats of current device.

        Toast.makeText(getActivity(), "Battery level: " + mBatteryHelper.getCurrentBatteryLevel() + "%", Toast.LENGTH_LONG).show();

        // Update device stats

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_devices_list, container, false);

        mListener.showAd();

        // Obtain recycler view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.devices_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new DeviceAdapter(getActivity(), mDevices);

        // Set adapter
        mRecyclerView.setAdapter(mAdapter);

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

    public List<Device> getDevices() {

        ParseQuery<Device> query = ParseQuery.getQuery(Device.DEVICES);
//                new ParseQuery<Device>(Device.DEVICES);
        query.whereEqualTo("deviceUser", ParseUser.getCurrentUser());
        query.findInBackground(new FindCallback<Device>() {
            @Override
            public void done(List<Device> devices, ParseException e) {
                if (e == null) {
                    // Loop through return devices
                    for (Device device : devices) {
                        Device currentDevice = new Device();
                        currentDevice.setDeviceName(device.getDeviceName());
                        currentDevice.setBatteryLevel(device.getBatteryLevel());
                        currentDevice.setIsCharging(device.isCharging());
                        mDevices.add(currentDevice);
                    }
                    mAdapter.notifyDataSetChanged();
                } else {
                    // Something went wrong
                    Toast.makeText(getActivity(), "Error: " + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return mDevices;
    }

    @Override
    public void onClick(View v) {
        // Click events go here
    }

    public static DevicesCardViewFragment newInstance(List<Device> mDevices) {
        DevicesCardViewFragment fragment = new DevicesCardViewFragment();

        Bundle args = new Bundle();

        return fragment;
    }

    public interface OnFragmentInteractionListener {
        public void showAd();
    }
}
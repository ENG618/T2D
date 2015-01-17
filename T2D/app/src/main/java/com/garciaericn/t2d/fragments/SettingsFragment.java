package com.garciaericn.t2d.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.garciaericn.t2d.R;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
public class SettingsFragment extends PreferenceFragment {

    public static final String TAG = "SettingsFragment.TAG";

    // Preference keys
    public static final String TEST_KEY = "TEST_KEY";

    public SettingsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate entered");

        //Load xml layout
        addPreferencesFromResource(R.xml.settings);
    }
}

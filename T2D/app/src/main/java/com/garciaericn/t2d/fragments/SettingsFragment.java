package com.garciaericn.t2d.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.garciaericn.t2d.DevicesActivity;
import com.garciaericn.t2d.R;
import com.parse.ParseUser;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener{

    public static final String TAG = "SettingsFragment.TAG";

    // Preference keys
    public static final String TEST_KEY = "TEST_KEY";
    public static final String LOG_OUT = "LOG_OUT";

    public SettingsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate entered");

        //Load xml layout
        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        switch (key) {
            case (key.equals(LOG_OUT)): {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
            }
        }
        return false;
    }
}

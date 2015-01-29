package com.garciaericn.t2d.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.widget.Toast;

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
    public static final String ABOUT = "ABOUT";

    public SettingsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate entered");

        //Load xml layout
        addPreferencesFromResource(R.xml.settings);

        // Set click listeners
        findPreference(TEST_KEY).setOnPreferenceClickListener(this);
        findPreference(LOG_OUT).setOnPreferenceClickListener(this);

    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {
            case (LOG_OUT): {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null

                Toast.makeText(getActivity(), "You have been logged out", Toast.LENGTH_SHORT).show();

                Intent relaodIntent = new Intent(getActivity(), DevicesActivity.class);
                startActivity(relaodIntent);
                return true;
            }
            case TEST_KEY: {
                Toast.makeText(getActivity(), "Testing", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }
}

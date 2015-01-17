package com.garciaericn.t2d;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.garciaericn.t2d.fragments.SettingsFragment;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
public class SettingsActivity extends Activity {

    private static final String TAG = "SettingsActivity.TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate entered");
        setContentView(R.layout.activity_settings);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        //Create and set preferences fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_fragment_container, new SettingsFragment(), SettingsFragment.TAG)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Log.i(TAG, "Up button pressed");
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}

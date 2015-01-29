package com.garciaericn.t2d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.garciaericn.t2d.data.Device;
import com.garciaericn.t2d.fragments.DevicesCardViewFragment;
import com.garciaericn.t2d.fragments.LogInFragment;
import com.garciaericn.t2d.fragments.SettingsFragment;
import com.garciaericn.t2d.fragments.SignUpFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;
import java.util.List;


public class DevicesActivity extends Activity implements
        DevicesCardViewFragment.OnFragmentInteractionListener,
        SignUpFragment.SignUpFragmentCallbacks,
        LogInFragment.LoginFragmentCallbacks{

    private static final int DETAIL_ACTIVITY_CODE = 100;

    private static final String DEVICE_ID = "3FCECABB61B244A968AC658FD8EE05D9";
    private AdView adView;
    private SharedPreferences settings;
    private List<Device> mDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);

        adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(DEVICE_ID).build();
        adView.loadAd(adRequest);

        settings = PreferenceManager.getDefaultSharedPreferences(this);
        if (settings.getBoolean(SettingsFragment.ABOUT, true)) {
            // Do initial load of device and stats
//            ParseObject newDevice = new ParseObject(Device);

            // Update settings
            settings.edit()
                    .putBoolean(SettingsFragment.ABOUT, false)
                    .apply();
        }


        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.list_container, DevicesCardViewFragment.newInstance())
                    .commit();
        } else {
            // show the sign up or login screen
            getFragmentManager().beginTransaction()
                    .replace(R.id.list_container, SignUpFragment.newInstance())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_devices, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void facebookSignUp() {
//        ParseFacebookUtils.logIn(this, new LogInCallback() {
//            @Override
//            public void done(ParseUser user, ParseException err) {
//                if (user == null) {
//                    Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
//                } else if (user.isNew()) {
//                    Log.d("MyApp", "User signed up and logged in through Facebook!");
//                } else {
//                    Log.d("MyApp", "User logged in through Facebook!");
//                }
//            }
//        });
    }

    @Override
    public void facebookLogin() {

    }

    @Override
    public void hideAd() {
        AdView adView = (AdView) this.findViewById(R.id.adView);
        adView.setVisibility(View.GONE);
    }

    @Override
    public void showAd() {
        AdView adView = (AdView) this.findViewById(R.id.adView);
        adView.setVisibility(View.VISIBLE);

    }

//    private class DevicesAdapter extends ParseQueryAdapter<Device> {
//
//        public DevicesAdapter(Context context, QueryFactory<Device> queryFactory) {
//            super(context, queryFactory);
//        }
//
//        @Override
//        public View getItemView(Device object, View v, ViewGroup parent) {
//            RecyclerView.ViewHolder holder;
//            if (v == null) {
////                v = inflater.infla
//            }
//        }
//    }
}

package com.garciaericn.t2d;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.garciaericn.t2d.data.BatteryHelper;
import com.garciaericn.t2d.fragments.DevicesCardViewFragment;
import com.garciaericn.t2d.fragments.LogInFragment;
import com.garciaericn.t2d.fragments.SignUpFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.parse.ParseUser;


public class DevicesActivity extends Activity implements
        DevicesCardViewFragment.OnFragmentInteractionListener,
        SignUpFragment.SignUpFragmentCallbacks,
        LogInFragment.LoginFragmentCallbacks {

    private static final int DETAIL_ACTIVITY_CODE = 100;

    private static final String DEVICE_ID = "3FCECABB61B244A968AC658FD8EE05D9";
    private AdView adView;
    private SharedPreferences settings;
    private BatteryHelper batteryHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);

        batteryHelper = new BatteryHelper(this);

        adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(DEVICE_ID).build();
        adView.loadAd(adRequest);

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
}

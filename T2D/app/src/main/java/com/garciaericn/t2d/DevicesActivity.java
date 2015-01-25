package com.garciaericn.t2d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.garciaericn.t2d.fragments.DevicesCardViewFragment;
import com.garciaericn.t2d.fragments.DevicesListFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class DevicesActivity extends Activity implements
        DevicesCardViewFragment.OnFragmentInteractionListener{

    private AdView adView;
    private static final String DEVICE_ID = "3FCECABB61B244A968AC658FD8EE05D9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);

        adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(DEVICE_ID).build();
        adView.loadAd(adRequest);

        // Enable Local Datastore.
//        Parse.enableLocalDatastore(this);
//
//        Parse.initialize(this, "mlbATdfRQ2RMJmNaVjjDcIybrtKnlEmic94bBL6r", "20c54czHXPKcb4ErBfbQe9q9vE9kaf6zS0A4GeLA");

        getFragmentManager().beginTransaction()
                .replace(R.id.list_container, DevicesCardViewFragment.newInstance())
//                .replace(R.id.list_container, DevicesListFragment.newInstance("test", "testing"))
                .commit();
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
}

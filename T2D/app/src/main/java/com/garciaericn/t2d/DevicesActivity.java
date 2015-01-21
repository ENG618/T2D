package com.garciaericn.t2d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.garciaericn.t2d.fragments.DevicesCardViewFragment;
import com.garciaericn.t2d.fragments.DevicesListFragment;


public class DevicesActivity extends Activity implements
        DevicesListFragment.OnFragmentInteractionListener,
        DevicesCardViewFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);

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

    @Override
    public void onFragmentInteraction(String id) {

    }
}

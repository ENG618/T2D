package com.garciaericn.t2d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
public class PowerMonitorReceiver extends BroadcastReceiver {

    private static final String TAG = "PowerMonitorReceiver.TAG";
    private float currentBatteryLevel;

    @Override
    public void onReceive(Context context, Intent intent) {


        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

        // Obtain action from intent to check which broadcast is being received
        String action = intent.getAction();

        // Perform action according to type
        switch (action) {
            case (Intent.ACTION_BATTERY_CHANGED): {
                Log.i(TAG, "Battery has changed");

                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

                currentBatteryLevel = (level * 100) / (float) scale;

                Toast.makeText(context, "Current battery level: " + Float.toString(currentBatteryLevel) + "%" + " level: " + level + " scale: " + scale, Toast.LENGTH_LONG).show();

                break;
            }
            case (Intent.ACTION_POWER_CONNECTED): {
                Log.i(TAG, "Power connected");

                int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
                boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

                String chargingType = null;

                if (usbCharge) {
                    chargingType = "USB";
                } else if (acCharge) {
                    chargingType = "AC Power";
                }

                if (chargingType != null) {
                    Toast.makeText(context, "Device is charging via: " + chargingType, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Device is charging.", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case (Intent.ACTION_POWER_DISCONNECTED): {
                Log.i(TAG, "Power disconnected");
                break;
            }
            case (Intent.ACTION_BATTERY_LOW): {
                Log.i(TAG, "Battery low");
                break;
            }
            case (Intent.ACTION_BATTERY_OKAY): {
                Log.i(TAG, "Battery Okay");
                break;
            }
        }
    }
}

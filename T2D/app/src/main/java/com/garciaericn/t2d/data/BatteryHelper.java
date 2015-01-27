package com.garciaericn.t2d.data;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/26/15.
 */
public class BatteryHelper {

    private final Context mContext;
    private Intent mBatteryStatus;

    public BatteryHelper(Context mContext) {
        this.mContext = mContext;
    }

    public int getCurrentBatteryLevel() {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        mBatteryStatus = mContext.registerReceiver(null, intentFilter);

        int level = mBatteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = mBatteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        return level * 100 / scale;
    }

    public boolean isCharging() {
        // Update to latest sticky intent
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        mBatteryStatus = mContext.registerReceiver(null, intentFilter);


        int chargeStatus = 0;
        if (mBatteryStatus != null) {
            chargeStatus = mBatteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        }

        return chargeStatus == BatteryManager.BATTERY_STATUS_CHARGING || chargeStatus == BatteryManager.BATTERY_STATUS_FULL;
    }

}

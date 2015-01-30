package com.garciaericn.t2d.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
@ParseClassName("Devices")
public class Device extends ParseObject {

    public static final String DEVICES = "Devices";

    public static final String DEVICE_NAME = "deviceName";
    public static final String BATTERY_LEVEL = "batteryLevel";
    public static final String IS_CHARGING = "isCharging";
    public static final String USER = "deviceUser";

    public Device() {
        // Required no arguments constructor
    }

    public String getUser() {
        return getString(USER);
    }

    public void setUser(ParseUser user) {
        put(USER, user);
    }

    public String getDeviceName() {
        return getString(DEVICE_NAME);
    }

    public void setDeviceName(String deviceName) {
        put(DEVICE_NAME, deviceName);
    }

    public int getBatteryLevel() {
        return getInt(BATTERY_LEVEL);
    }


    public void setBatteryLevel(int batateryLevel) {
        put(BATTERY_LEVEL, batateryLevel);
    }

    public boolean isCharging() {
        return getBoolean(IS_CHARGING);
    }

    public void setIsCharging(boolean isCharging) {
        put(IS_CHARGING, isCharging);
    }

    public static ParseQuery<Device> getQuery() {
        return ParseQuery.getQuery(Device.class);
    }
}

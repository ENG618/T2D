package com.garciaericn.t2d.data;

import com.parse.ParseObject;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
public class Device extends ParseObject{

    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String CURRENT_BATTERY_LEVEL = "CURRENT_BATTERY_LEVEL";
    public static final String IS_CHARGING = "IS_CHARGING";

    private String deviceName;
    private float currentBatteryLevel;
    private boolean isCharging;

    public Device() {
    }

    public Device(String deviceName, float currentBatteryLevel, boolean isCharging) {
        this.deviceName = deviceName;
        this.currentBatteryLevel = currentBatteryLevel;
        this.isCharging = isCharging;


        ParseObject device = new ParseObject("Device");
        device.put(DEVICE_NAME, deviceName);
        device.put(CURRENT_BATTERY_LEVEL, currentBatteryLevel);
        device.put(IS_CHARGING, isCharging);
        device.pinInBackground();
        device.saveInBackground();

    }

    // Getters and Setters


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public float getCurrentBatteryLevel() {
        return currentBatteryLevel;
    }

    public void setCurrentBatteryLevel(float currentBatteryLevel) {
        this.currentBatteryLevel = currentBatteryLevel;
    }

    public boolean isCharging() {
        return isCharging;
    }

    public void setCharging(boolean isCharging) {
        this.isCharging = isCharging;
    }

    public void updateDeviceInParse() {

    }
}

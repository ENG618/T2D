package com.garciaericn.t2d.data;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
public class Device {

    private String deviceName;
    private float currentBateryLevel;
    private boolean isCharging;

    public Device() {
    }

    public Device(String deviceName, float currentBateryLevel, boolean isCharging) {
        this.deviceName = deviceName;
        this.currentBateryLevel = currentBateryLevel;
        this.isCharging = isCharging;
    }

    // Getters and Setters


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public float getCurrentBateryLevel() {
        return currentBateryLevel;
    }

    public void setCurrentBateryLevel(float currentBateryLevel) {
        this.currentBateryLevel = currentBateryLevel;
    }

    public boolean isCharging() {
        return isCharging;
    }

    public void setCharging(boolean isCharging) {
        this.isCharging = isCharging;
    }
}

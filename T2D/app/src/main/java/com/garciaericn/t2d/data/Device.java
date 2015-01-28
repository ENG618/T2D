package com.garciaericn.t2d.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.UUID;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/17/15.
 */
@ParseClassName("Devices")
public class Device extends ParseObject {

    private static final String DEVICE_NAME = "deviceName";
    private static final String BATTERY_LEVEL = "batteryLevel";
    private static final String IS_CHARGING = "isCharging";
    private static final String DEVICE_UUID = "uuid";
    private static final String USER = "deviceUser";

    public String getUser() {
        return getString(USER);
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

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put(DEVICE_UUID, uuid.toString());
    }

    public String getUuidString() {
        return getString(DEVICE_UUID);
    }

    public static ParseQuery<Device> getQuery() {
        return ParseQuery.getQuery(Device.class);
    }
}

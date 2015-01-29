package com.garciaericn.t2d.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garciaericn.t2d.R;

import java.util.Collections;
import java.util.List;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/24/15.
 */
public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.MyViewHolder> {

    private final LayoutInflater inflater;

    List<Device> data = Collections.emptyList();

    public DeviceAdapter(Context context, List<Device> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_layout, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Device device = data.get(position);

        holder.deviceNameTV.setText(device.getDeviceName());
        holder.batteryLevelTV.setText(device.getBatteryLevel());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // Temp data set
        private String[] mDataset;

        TextView deviceNameTV;
        TextView batteryLevelTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            deviceNameTV = (TextView) itemView.findViewById(R.id.device_name_tv);
            batteryLevelTV = (TextView) itemView.findViewById(R.id.battery_level_tv);
        }
    }
}



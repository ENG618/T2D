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

    private LayoutInflater inflater;
    private Context context;
    private ClickListener clickListener;

    List<Device> data = Collections.emptyList();

    public DeviceAdapter(Context context, List<Device> data) {
        inflater = LayoutInflater.from(context);
        this.context = context;
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

        String batteryLevelString = String.valueOf(device.getBatteryLevel()) + "%";

        holder.deviceNameTV.setText(device.getDeviceName());
        holder.batteryLevelTV.setText(batteryLevelString);

        if (device.isCharging()) {
            holder.isChargingTV.setText("Is charging");
        } else {
            holder.isChargingTV.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Temp data set
        private String[] mDataset;

        TextView deviceNameTV;
        TextView batteryLevelTV;
        TextView isChargingTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            deviceNameTV = (TextView) itemView.findViewById(R.id.device_name_tv);
            batteryLevelTV = (TextView) itemView.findViewById(R.id.battery_level_tv);
            isChargingTV = (TextView) itemView.findViewById(R.id.isChargingTV);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.deviceSelected(view, getPosition());
            }
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void deviceSelected(View view, int position);
    }
}



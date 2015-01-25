package com.garciaericn.t2d;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Full Sail University
 * Mobile Development BS
 * Created by ENG618-Mac on 1/24/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Temp data set
        private String[] mDataset;

        TextView deviceNameTV;
        TextView batteryLevelTV;

        public ViewHolder(View itemView) {
            super(itemView);
            this.deviceNameTV = (TextView) itemView.findViewById(R.id.device_name_tv);
            this.batteryLevelTV = (TextView) itemView.findViewById(R.id.battery_level_tv);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }







//
//        // Provide a suitable constructor (depends on the kind of dataset)
//        public MyAdapter(String[] myDataset) {
//            mDataset = myDataset;
//        }
//
//        // Create new views (invoked by the layout manager)
//        @Override
//        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
//                                                       int viewType) {
//            // create a new view
//            View v = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.my_text_view, parent, false);
//            // set the view's size, margins, paddings and layout parameters
//            ...
//            ViewHolder vh = new ViewHolder(v);
//            return vh;
//        }
//
//        // Replace the contents of a view (invoked by the layout manager)
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            // - get element from your dataset at this position
//            // - replace the contents of the view with that element
//            holder.mTextView.setText(mDataset[position]);
//
//        }
//
//        // Return the size of your dataset (invoked by the layout manager)
//        @Override
//        public int getItemCount() {
//            return mDataset.length;
//        }







    }



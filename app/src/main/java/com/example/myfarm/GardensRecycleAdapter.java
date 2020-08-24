package com.example.myfarm;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfarm.DataBase.GardenEntity;

import java.util.List;

public class GardensRecycleAdapter extends RecyclerView.Adapter<GardensRecycleAdapter.GardenViewHolder>{



    class GardenViewHolder extends RecyclerView.ViewHolder{

        public TextView gardenTextView;

        public GardenViewHolder(@NonNull View itemView) {
            super(itemView);
            gardenTextView = itemView.findViewById(R.id.list_tv);
        }
    }

    private final LayoutInflater mInflater;
    private List<GardenEntity> mGardens;

    GardensRecycleAdapter(Fragment fragment) {mInflater = LayoutInflater.from(fragment.getContext());}


    @NonNull
    @Override
    public GardensRecycleAdapter.GardenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.list_item_layout, parent, false);


        return new  GardenViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull GardensRecycleAdapter.GardenViewHolder holder, int position) {

        if (mGardens != null){
            GardenEntity current = mGardens.get(position);
            holder.gardenTextView.setText(current.getName());
        }
        else {
            holder.gardenTextView.setText("No Orchard");
        }
    }

    void setmGardens(List<GardenEntity> words){
        mGardens = words;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        if (mGardens != null){
            return mGardens.size();
        }
        else {
            return 0;
        }
        }
}

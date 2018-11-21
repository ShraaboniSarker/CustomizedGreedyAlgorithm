package com.example.shraboni.algorithmdesignforads.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shraboni.algorithmdesignforads.R;
import com.example.shraboni.algorithmdesignforads.model.addvertise.Advertise;

import java.util.ArrayList;

public class AddAdvertiseAdapter extends RecyclerView.Adapter<AddAdvertiseAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Advertise> list;

    public AddAdvertiseAdapter(Context context, ArrayList<Advertise> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tvAddName.setText(list.get(i).getAddname());
        myViewHolder.tvAddTime.setText(list.get(i).getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvAddName,tvAddTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddName = itemView.findViewById(R.id.tvAddName);
            tvAddTime = itemView.findViewById(R.id.tvAddTime);
        }
    }
}

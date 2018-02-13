package com.example.aduser.retrofiteg;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aduser.retrofiteg.networking.response.UserResponse;

import java.util.List;

/**
 * Created by aduser on 2/12/2018.
 */

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.MyViewHolder> {
    private List<UserResponse> dataList;

    public DataAdaptor(List<UserResponse> dataList) {
        this.dataList=dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserResponse dataClass = dataList.get(position);
        holder.name_id.setText(dataClass.getTitle());
        holder.phone_id.setText(dataClass.getBody());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addAll(List<UserResponse> body) {
        dataList.clear();
        dataList.addAll(body);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name_id,phone_id;

        public MyViewHolder(View view) {
            super(view);
            name_id = view.findViewById(R.id.name_id);
            phone_id = view.findViewById(R.id.phone_id);
        }

    }
}

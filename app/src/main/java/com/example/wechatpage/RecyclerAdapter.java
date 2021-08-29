package com.example.wechatpage;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<JavaBean> localDataSet;

    public RecyclerAdapter(ArrayList<JavaBean> dataSet){
        localDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvName;
        private final TextView tvPhone;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tvName =  itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
        }

        public TextView getTvName(){
            return tvName;
        }
        public TextView getTvPhone(){
            return tvPhone;
        }

    }

    @Override
    public @NotNull ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAdapter.ViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: "+ localDataSet.get(position).getName());
        TextView tvName = holder.getTvName();
        TextView tvPhone = holder.getTvPhone();

        tvName.setText(localDataSet.get(position).getName());
        tvPhone.setText(localDataSet.get(position).getPhone());
//        holder.getTvName().setText(localDataSet.get(position).getName());
//        holder.getTvPhone().setText(localDataSet.get(position).getPhone());
    }



    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


}

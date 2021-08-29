package com.example.wechatpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private ArrayList<JavaBean> dataList = null;

    @Override
    public int getCount() {
        if (dataList == null){
            return 0;
        }
        return dataList.size();
    }

    public void setData(ArrayList<JavaBean> dataList){
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public JavaBean getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private View bindData2View(View view,JavaBean data){

        TextView name = view.findViewById(R.id.tv_name);
        TextView phone = view.findViewById(R.id.tv_phone);

        name.setText(data.getName());
        phone.setText(data.getPhone());

        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_content,parent,false);
        bindData2View(view,dataList.get(position));
        return view;
    }
}

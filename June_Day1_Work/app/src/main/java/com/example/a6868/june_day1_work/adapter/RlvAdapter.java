package com.example.a6868.june_day1_work.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a6868.june_day1_work.R;

import java.util.ArrayList;

import com.example.a6868.june_day1_work.bean.HomeBean;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder>{
    private ArrayList<HomeBean.DataBean> list_item = new ArrayList<>();
    private Context context;

    public RlvAdapter(ArrayList<HomeBean.DataBean> list_item, Context context) {
        this.list_item = list_item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list_item.get(i).getThumbnail()).into(viewHolder.item_iv);
        viewHolder.item_tv.setText(list_item.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView item_iv;
        private final TextView item_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_iv = itemView.findViewById(R.id.item_iv);
            item_tv = itemView.findViewById(R.id.item_tv);
        }
    }
}

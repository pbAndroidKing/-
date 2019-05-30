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
import com.example.a6868.june_day1_work.bean.ChildBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RlvChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<ChildBean.StoriesBean> list_item;
    private ArrayList<ChildBean.TopStoriesBean> list_banner;
    private Context context;

    public RlvChildAdapter(ArrayList<ChildBean.StoriesBean> list_item, ArrayList<ChildBean.TopStoriesBean> list_banner, Context context) {
        this.list_item = list_item;
        this.list_banner = list_banner;
        this.context = context;
    }

    public void setList_item(ArrayList<ChildBean.StoriesBean> list_item) {
        this.list_item = list_item;
        notifyDataSetChanged();
    }

    public void setList_banner(ArrayList<ChildBean.TopStoriesBean> list_banner) {
        this.list_banner = list_banner;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        if (i == 0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_child_banner, null);
            holder = new MyBannerVierHolder(inflate);
        }else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_child, null);
            holder = new MyItemViewHolder(inflate);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);

        if (viewHolder instanceof MyBannerVierHolder){
            MyBannerVierHolder myBannerVierHolder = (MyBannerVierHolder) viewHolder;
            myBannerVierHolder.item_banner.setImages(list_banner);
            myBannerVierHolder.item_banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    String image = list_banner.get(i).getImage();
                    path = image;
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
        }else if (itemViewType == 1){
            MyItemViewHolder myItemViewHolder = (MyItemViewHolder) viewHolder;
            Glide.with(context).load(list_item.get(i).getImages()).into(myItemViewHolder.child_iv);
            myItemViewHolder.child_tv.setText(list_item.get(i).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }else {
            return 1;
        }
    }

    private class MyBannerVierHolder extends RecyclerView.ViewHolder {

        private final Banner item_banner;

        public MyBannerVierHolder(@NonNull View itemView) {
            super(itemView);
            item_banner = itemView.findViewById(R.id.item_Banner);
        }
    }

    private class MyItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView child_iv;
        private final TextView child_tv;

        public MyItemViewHolder(@NonNull View itemView) {
            super(itemView);
            child_iv = itemView.findViewById(R.id.child_iv);
            child_tv = itemView.findViewById(R.id.child_tv);
        }
    }
}

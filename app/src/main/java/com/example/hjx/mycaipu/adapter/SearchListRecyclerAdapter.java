package com.example.hjx.mycaipu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hjx.mycaipu.R;
import com.example.hjx.mycaipu.bean.SearchListRecyclerItemBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class SearchListRecyclerAdapter extends RecyclerView.Adapter<SearchListRecyclerAdapter.MyHolder> {
    private Context context;
    private ArrayList<SearchListRecyclerItemBean> list;

    public SearchListRecyclerAdapter(Context context1, ArrayList<SearchListRecyclerItemBean> list) {
        this.context = context1;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.searchlit_item_layout, parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(context).
                load(list.get(position).getImg()).
                placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).
                into(holder.searchlist_item_img);

        holder.searchlist_item_name.setText(list.get(position).getName());
        holder.searchlist_item_info.setText(list.get(position).getInfo());
        holder.searchlist_item_eye.setText(list.get(position).getEye());
        holder.searchlist_item_sc.setText(list.get(position).getCs());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView searchlist_item_img;
        TextView searchlist_item_name;
        TextView searchlist_item_info;
        TextView searchlist_item_eye;
        TextView searchlist_item_sc;

        public MyHolder(View itemView) {
            super(itemView);
            searchlist_item_img = (ImageView) itemView.findViewById(R.id.searchlist_item_img);
            searchlist_item_name = (TextView) itemView.findViewById(R.id.searchlist_item_name);
            searchlist_item_info = (TextView) itemView.findViewById(R.id.searchlist_item_info);
            searchlist_item_eye = (TextView) itemView.findViewById(R.id.searchlist_item_eye);
            searchlist_item_sc = (TextView) itemView.findViewById(R.id.searchlist_item_sc);
        }


    }


}

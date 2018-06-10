package com.example.hjx.mycaipu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hjx.mycaipu.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchRecyclerAdapter.MyHolder> {
    private Context context;
    private ArrayList<String> list;

    public SearchRecyclerAdapter(Context context1, ArrayList<String> list) {
        this.context = context1;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_item_layout, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.search_item_name.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView search_item_name;

        public MyHolder(View itemView) {
            super(itemView);
            search_item_name = (TextView) itemView.findViewById(R.id.search_item_name);
        }
    }


}

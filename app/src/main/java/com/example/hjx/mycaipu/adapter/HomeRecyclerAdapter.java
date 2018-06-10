package com.example.hjx.mycaipu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hjx.mycaipu.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyHolder> {
    private Context context;
    private ArrayList<String> list;
    private View views;

    public HomeRecyclerAdapter(Context context1, ArrayList<String> list,View view) {
        this.context = context1;
        this.list = list;
        this.views = view;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType==0){
            view = views;
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        }
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
//        holder.img.setBackgroundResource(R.mipmap.ic_launcher);
        if(getItemViewType(position)!=0){

            Glide.with(context).
                    load("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg").
                    placeholder(R.mipmap.ic_launcher_round).
//                bitmapTransform(new RoundedCornersTransformation((BitmapPool) this, 24, 0,
//                RoundedCornersTransformation.CornerType.ALL)).
        error(R.mipmap.ic_launcher).
                    into(holder.img);

            holder.name.setText(list.get(position));

        }

//        RelativeLayout.LayoutParams linearParams =(RelativeLayout.LayoutParams) holder.layout.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
//        linearParams.height = (int)100+(int)(Math.random()*(200));;// 控件的宽强制设成30
//        holder.layout.setLayoutParams(linearParams); //使设置好的布局参数应用到控件


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        RelativeLayout layout;

        public MyHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            layout = (RelativeLayout) itemView.findViewById(R.id.layout);
        }
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }
}

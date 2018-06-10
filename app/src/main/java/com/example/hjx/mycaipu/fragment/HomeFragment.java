package com.example.hjx.mycaipu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hjx.mycaipu.R;
import com.example.hjx.mycaipu.SearchActivity;
import com.example.hjx.mycaipu.adapter.HomeRecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by whwlu on 2018/5/30.
 */

public class HomeFragment extends Fragment {
    private RecyclerView main_recycler;
    private LinearLayout home_fragment_input;

    String [] imgs = {
            "http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760446_3641.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760445_3283.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760444_8623.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760444_6822.jpg",
            "http://img.my.csdn.net/uploads/201508/05/1438760422_2224.jpg"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment_layout,null);
        init(view);
        return view;
    }
    private void init(View view) {
        findView(view);
        setOnclick();
    }

    private void setOnclick() {
        home_fragment_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findView(View view) {
        main_recycler = (RecyclerView) view.findViewById(R.id.home_recycler);
        home_fragment_input = (LinearLayout) view.findViewById(R.id.home_fragment_input);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        main_recycler.setLayoutManager(layoutManager);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(RecyclerViewActivity.this,5);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
//       recycler.setLayoutManager(gridLayoutManager);

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        main_recycler.setHasFixedSize(true);
//        main_recycler.setLayoutManager(staggeredGridLayoutManager);


        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<imgs.length;i++){
            list.add(imgs[i]);
        }

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.home_top_layout,null);
        main_recycler.setAdapter(new HomeRecyclerAdapter(getActivity(),list,v));

    }
}

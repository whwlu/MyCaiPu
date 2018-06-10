package com.example.hjx.mycaipu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hjx.mycaipu.adapter.SearchListRecyclerAdapter;
import com.example.hjx.mycaipu.bean.SearchListRecyclerItemBean;

import java.util.ArrayList;

public class SearchListActivity extends AppCompatActivity {
    private RecyclerView searchlist_recycler;
    private ArrayList<SearchListRecyclerItemBean> list = new ArrayList<SearchListRecyclerItemBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        init();
    }

    private void init() {
        findView();
        setAdapter();
    }

    private void setAdapter() {
        for(int i=0;i<20;i++){
            SearchListRecyclerItemBean bean = new SearchListRecyclerItemBean();
            bean.setImg("http://img.my.csdn.net/uploads/201508/05/1438760444_8623.jpg");
            bean.setName("鱼香肉丝");
            bean.setInfo("猪肉里脊");
            bean.setEye("10000浏览");
            bean.setCs("9999收藏");
            list.add(bean);
        }



        searchlist_recycler.setAdapter(new SearchListRecyclerAdapter(SearchListActivity.this,list));
    }

    private void findView() {
        searchlist_recycler = (RecyclerView) findViewById(R.id.searchlist_recycler);


        LinearLayoutManager layoutManager =new LinearLayoutManager(SearchListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        searchlist_recycler.setLayoutManager(layoutManager);
    }
}

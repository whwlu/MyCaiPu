package com.example.hjx.mycaipu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hjx.mycaipu.adapter.SearchRecyclerAdapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    RecyclerView search_recycler;
    TextView search_cancle;
    RelativeLayout search_input;
    EditText search_editext;
    ArrayList<String> list = new ArrayList<String>();
    boolean isLength = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
    }

    private void init() {
        findView();
        setAdapter();
        setOnclick();
    }

    private void setOnclick() {
        search_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLength){//>0
                    Intent intent = new Intent(SearchActivity.this,SearchListActivity.class);
                    startActivity(intent);
                }else{

                    finish();
                }
            }
        });
//        search_input.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SearchActivity.this,SearchListActivity.class);
//                startActivity(intent);
//            }
//        });
        search_editext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0){//输入框里面输入的有东西了
                    isLength = true;
                    search_cancle.setText("搜索");
                }else{
                    isLength = false;
                    search_cancle.setText("取消");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        search_editext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){


                }
                return false;
            }
        });
    }

    private void setAdapter() {
        list.add("卤菜");
        list.add("黄焖鸡黄焖鸡黄焖");
        list.add("包子");
        list.add("牛排");
        list.add("早餐");
        list.add("豆腐干");
        list.add("123");
        list.add("卤菜");
        list.add("黄焖鸡");
        list.add("包子");
        list.add("牛排");
        list.add("早餐");
        list.add("豆腐干");
        list.add("123");
        list.add("卤菜");
        list.add("黄焖鸡");
        list.add("包子");
        list.add("牛排");
        list.add("早餐");
        list.add("豆腐干");
        list.add("123");


        search_recycler.setAdapter(new SearchRecyclerAdapter(SearchActivity.this,list));
    }

    private void findView() {
        search_recycler = (RecyclerView) findViewById(R.id.search_recycler);
        search_cancle = (TextView) findViewById(R.id.search_cancle);
        search_input = (RelativeLayout) findViewById(R.id.search_input);
        search_editext = (EditText) findViewById(R.id.search_editext);

        LinearLayoutManager layoutManager =new LinearLayoutManager(SearchActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        search_recycler.setLayoutManager(layoutManager);

    }



}

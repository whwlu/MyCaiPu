package com.example.hjx.mycaipu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hjx.mycaipu.fragment.TimeDishZCFragment;

import java.util.ArrayList;

public class TimeDishActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView time_dish_back;
    private ImageView time_dish_search;
    private TextView time_dish_zc_text;
    private TextView time_dish_zc_line;
    private TextView time_dish_wc_text;
    private TextView time_dish_wc_line;
    private TextView time_dish_dl_text;
    private TextView time_dish_dl_line;
    private android.support.v4.view.ViewPager time_dish_viewpager;

    int position = 0;//当前选中的是哪一个

    ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_dish);
        init();
    }

    private void init() {
        getIntents();
        findView();
        setOnclick();
        initViewPager();
    }

    private void getIntents() {
        position = getIntent().getIntExtra("position", 0);
    }

    private void initViewPager() {
        TimeDishZCFragment one = new TimeDishZCFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", "我是早餐");
        one.setArguments(bundle);

        TimeDishZCFragment two = new TimeDishZCFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", "我是午餐");
        two.setArguments(bundle1);

        TimeDishZCFragment three = new TimeDishZCFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", "我是晚餐");
        three.setArguments(bundle2);

        fragments.add(one);
        fragments.add(two);
        fragments.add(three);


        time_dish_viewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        time_dish_viewpager.setCurrentItem(position);

        time_dish_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        time_dish_zc_text.setTextColor(Color.parseColor("#ff8373"));
                        time_dish_zc_line.setBackgroundResource(R.color.cc);

                        time_dish_wc_text.setTextColor(R.color.black);
                        time_dish_wc_line.setBackgroundResource(R.color.black);
                        time_dish_dl_text.setTextColor(R.color.black);
                        time_dish_dl_line.setBackgroundResource(R.color.black);


                        break;
                    case 1:

                        time_dish_zc_text.setTextColor(R.color.black);
                        time_dish_zc_line.setBackgroundResource(R.color.black);

                        time_dish_wc_text.setTextColor(Color.parseColor("#ff8373"));
                        time_dish_wc_line.setBackgroundResource(R.color.cc);
                        time_dish_dl_text.setTextColor(R.color.black);
                        time_dish_dl_line.setBackgroundResource(R.color.black);
                        break;
                    case 2:

                        time_dish_zc_text.setTextColor(R.color.black);
                        time_dish_zc_line.setBackgroundResource(R.color.black);

                        time_dish_wc_text.setTextColor(R.color.black);
                        time_dish_wc_line.setBackgroundResource(R.color.black);
                        time_dish_dl_text.setTextColor(Color.parseColor("#ff8373"));
                        time_dish_dl_line.setBackgroundResource(R.color.cc);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setOnclick() {
        time_dish_back.setOnClickListener(this);
        time_dish_search.setOnClickListener(this);
        time_dish_zc_text.setOnClickListener(this);
        time_dish_wc_text.setOnClickListener(this);
        time_dish_dl_text.setOnClickListener(this);
    }

    private void findView() {
        time_dish_back = (ImageView) findViewById(R.id.time_dish_back);
        time_dish_search = (ImageView) findViewById(R.id.time_dish_search);
        time_dish_zc_text = (TextView) findViewById(R.id.time_dish_zc_text);
        time_dish_zc_line = (TextView) findViewById(R.id.time_dish_zc_line);
        time_dish_wc_text = (TextView) findViewById(R.id.time_dish_wc_text);
        time_dish_wc_line = (TextView) findViewById(R.id.time_dish_wc_line);
        time_dish_dl_text = (TextView) findViewById(R.id.time_dish_dl_text);
        time_dish_dl_line = (TextView) findViewById(R.id.time_dish_dl_line);
        time_dish_viewpager = (android.support.v4.view.ViewPager) findViewById(R.id.time_dish_viewpager);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.time_dish_back:
                finish();
                break;
            case R.id.time_dish_search:
                Intent intent = new Intent(TimeDishActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.time_dish_zc_text:
                time_dish_zc_text.setTextColor(Color.parseColor("#ff8373"));
                time_dish_zc_line.setBackgroundResource(R.color.cc);

                time_dish_wc_text.setTextColor(R.color.black);
                time_dish_wc_line.setBackgroundResource(R.color.black);
                time_dish_dl_text.setTextColor(R.color.black);
                time_dish_dl_line.setBackgroundResource(R.color.black);
                time_dish_viewpager.setCurrentItem(0);
                break;
            case R.id.time_dish_wc_text:


                time_dish_zc_text.setTextColor(R.color.black);
                time_dish_zc_line.setBackgroundResource(R.color.black);

                time_dish_wc_text.setTextColor(Color.parseColor("#ff8373"));
                time_dish_wc_line.setBackgroundResource(R.color.cc);
                time_dish_dl_text.setTextColor(R.color.black);
                time_dish_dl_line.setBackgroundResource(R.color.black);
                time_dish_viewpager.setCurrentItem(1);

                break;
            case R.id.time_dish_dl_text:
                time_dish_zc_text.setTextColor(R.color.black);
                time_dish_zc_line.setBackgroundResource(R.color.black);

                time_dish_wc_text.setTextColor(R.color.black);
                time_dish_wc_line.setBackgroundResource(R.color.black);
                time_dish_dl_text.setTextColor(Color.parseColor("#ff8373"));
                time_dish_dl_line.setBackgroundResource(R.color.cc);
                time_dish_viewpager.setCurrentItem(2);
                break;
        }
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


}

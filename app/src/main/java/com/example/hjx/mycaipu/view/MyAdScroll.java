package com.example.hjx.mycaipu.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hjx.mycaipu.R;
import com.example.hjx.mycaipu.TimeDishActivity;

import java.util.ArrayList;

/**
 * Created by whwlu on 2018/5/28.
 */

public class MyAdScroll extends LinearLayout {
    private ViewPager viewpager;
    private ImageView img1;
    private ImageView img2;
    //创建一个view数组
    ArrayList<View> views = new ArrayList<View>();

    public MyAdScroll(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    /*
    * 初始化view
    * */
    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_ad_sroll_layout,this);
        findView(view);
        setAdapter();
    }

    private void setAdapter() {
        //初始化的数据
        for(int i=0,j=2;i<j;i++){
            View view = LayoutInflater.from(getContext()).inflate(R.layout.my_ad_sroll_layout,null);
//            ImageView view = new ImageView(getContext());
//            view.setBackgroundResource(R.mipmap.ic_launcher);
            final int finalI = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), TimeDishActivity.class);
                    intent.putExtra("position", finalI);
                    getContext().startActivity(intent);
                }
            });
            views.add(view);
        }
        //设置适配器
        viewpager.setAdapter(new MyAdapter());

        viewpager.setCurrentItem(0);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    img1.setBackgroundResource(R.color.red);
                    img2.setBackgroundResource(R.color.white);
                }else{
                    img2.setBackgroundResource(R.color.red);
                    img1.setBackgroundResource(R.color.white);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /*
    * 找控件
    * */
    private void findView(View view) {
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        img1 = (ImageView) view.findViewById(R.id.img1);
        img2 = (ImageView) view.findViewById(R.id.img2);
    }
    /*
    * 创建的适配器
    * */
    private class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }
    }

}

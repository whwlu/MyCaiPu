package com.example.hjx.mycaipu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hjx.mycaipu.fragment.ClassFragment;
import com.example.hjx.mycaipu.fragment.HomeFragment;
import com.example.hjx.mycaipu.fragment.MoreFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager home_viewpager;
    private LinearLayout home_home;
    private LinearLayout home_class;
    private LinearLayout home_more;
    private ImageView home_home_img;
    private ImageView home_class_img;
    private ImageView home_more_img;
    ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        init();
    }
    /*
    * 初始化
    * */
    private void init() {
        findView();
        setAdapter();
        setOnclick();
        changeViewpger();
    }

    private void changeViewpger() {
        home_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0://点击第一个
                        home_home_img.setBackgroundResource(R.mipmap.z_home_menu_ico_index_active);
                        home_class_img.setBackgroundResource(R.mipmap.z_home_menu_ico_class);
                        home_more_img.setBackgroundResource(R.mipmap.z_home_menu_ico_more);
                        break;
                    case 1://点击第二个
                        home_home_img.setBackgroundResource(R.mipmap.z_home_menu_ico_index);
                        home_class_img.setBackgroundResource(R.mipmap.z_home_menu_ico_class_active);
                        home_more_img.setBackgroundResource(R.mipmap.z_home_menu_ico_more);

                        break;
                    case 2://点击第三个
                        home_home_img.setBackgroundResource(R.mipmap.z_home_menu_ico_index);
                        home_class_img.setBackgroundResource(R.mipmap.z_home_menu_ico_class);
                        home_more_img.setBackgroundResource(R.mipmap.z_home_menu_ico_more_active);

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*
    * 设置点击事件
    * */
    private void setOnclick() {
        home_home.setOnClickListener((View.OnClickListener) HomeActivity.this);
        home_class.setOnClickListener((View.OnClickListener) HomeActivity.this);
        home_more.setOnClickListener((View.OnClickListener) HomeActivity.this);

    }

    private void setAdapter() {
        //初始化一下fragments  就是把我们需要的fragment放进这个数组里面
        fragments.add(new HomeFragment());
        fragments.add(new ClassFragment());
        fragments.add(new MoreFragment());


        //给viewpager设置适配器
        home_viewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    private void findView() {
        home_viewpager = (ViewPager) findViewById(R.id.home_viewpager);

        home_home = (LinearLayout) findViewById(R.id.home_home);
        home_class = (LinearLayout) findViewById(R.id.home_class);
        home_more = (LinearLayout) findViewById(R.id.home_more);

        home_more_img = (ImageView) findViewById(R.id.home_more_img);
        home_class_img = (ImageView) findViewById(R.id.home_class_img);
        home_home_img = (ImageView) findViewById(R.id.home_home_img);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_home://点击第一个
                home_home_img.setBackgroundResource(R.mipmap.z_home_menu_ico_index_active);
                home_class_img.setBackgroundResource(R.mipmap.z_home_menu_ico_class);
                home_more_img.setBackgroundResource(R.mipmap.z_home_menu_ico_more);
                home_viewpager.setCurrentItem(0);
                break;
            case R.id.home_class://点击第二个
                home_home_img.setBackgroundResource(R.mipmap.z_home_menu_ico_index);
                home_class_img.setBackgroundResource(R.mipmap.z_home_menu_ico_class_active);
                home_more_img.setBackgroundResource(R.mipmap.z_home_menu_ico_more);
                home_viewpager.setCurrentItem(1);
                break;
            case R.id.home_more://点击第三个
                home_home_img.setBackgroundResource(R.mipmap.z_home_menu_ico_index);
                home_class_img.setBackgroundResource(R.mipmap.z_home_menu_ico_class);
                home_more_img.setBackgroundResource(R.mipmap.z_home_menu_ico_more_active);
                home_viewpager.setCurrentItem(2);
                break;
        }
    }


    /*
    *
    * 自定义了一个内部类实现了一个适配器
    * */
    public class MyAdapter extends FragmentPagerAdapter{
        //构造方法  需要传递进来的参数
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        //当前是那个fragment
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        //一共有多少fragment
        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}

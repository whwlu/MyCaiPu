package com.example.hjx.mycaipu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hjx.mycaipu.R;

/**
 * Created by whwlu on 2018/5/31.
 */

public class TimeDishZCFragment extends Fragment {
    private TextView time_dish_fragment_text;

     String currentName ;//我们当前是哪一个fragment

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.time_dish_zcfragment_layout,null);

        currentName = getArguments().getString("name").toString();
        init(view);
        return view;
    }

    private void init(View view) {
        getIntents();
        findView(view);
    }

    private void getIntents() {
        Bundle bundle = getArguments();
    }

    private void findView(View view){
        time_dish_fragment_text = (TextView)view.findViewById(R.id.time_dish_fragment_text);
        time_dish_fragment_text.setText(currentName);
    }


}

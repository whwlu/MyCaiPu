package com.example.hjx.mycaipu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }

    private void start() {
        //创建一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);//线程休眠
                    mHandler.sendEmptyMessage(0);//给handler发送消息

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /*
    * 创建的一个handler接收消息
    * */
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0://接收到对应的消息

                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();

                    break;
                case 1:

                    break;
            }
        }
    };

}

package com.louisgeek.louisbroadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 *    //接受自定义广播
 * Created by louisgeek on 2016/5/19.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    private final String MY_BROADCAST = "com.louisgeek.louisbroadcastreceiverdemo.MY_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(MY_BROADCAST.equals(intent.getAction())) {
            Toast.makeText(context, "收到MY_BROADCAST啦~", Toast.LENGTH_SHORT).show();
        }
    }
}

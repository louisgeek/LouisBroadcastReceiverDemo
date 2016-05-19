package com.louisgeek.louisbroadcastreceiverdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 前面写的广播都是全局广播！这同样意味着我们APP发出的广播，其他APP都会接收到， 或者其他APP发送的广播，我们的APP也同样会接收到，这样容易引起一些安全性的问题！而 Android中给我们提供了本地广播的机制，使用该机制发出的广播只会在APP内部传播，而且 广播接收者也只能收到本应用发出的广播！
 * LocalBroadcastManager   见：http://www.runoob.com/w3cnote/android-tutorial-broadcastreceiver-2.html
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button idbtnsend = (Button) findViewById(R.id.id_btn_send);
        idbtnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送自定义广播
                sendBroadcast(new Intent("com.louisgeek.louisbroadcastreceiverdemo.MY_BROADCAST"));
                //发送有序的广播 有序广播根据注册Receiver时的IntentFilter的Priority排序。priority范围Integer.MIN～Integer.MAX，系统注册Receiver的IntentFIlter的priority的范围-1000～1000。
                //sendOrderedBroadcast(new Intent("com.louisgeek.louisbroadcastreceiverdemo.MY_BROADCAST"), null);
            }
        });
    }
}

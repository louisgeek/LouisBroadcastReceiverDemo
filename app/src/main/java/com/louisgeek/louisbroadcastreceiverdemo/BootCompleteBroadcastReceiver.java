package com.louisgeek.louisbroadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 不要在广播里添加过多逻辑或者进行任何耗时操作,因为在广播中是不允许开辟线程的, 当onReceiver( )方法运行较长时间(超过10秒)还没有结束的话,那么程序会报错(ANR), 广播更多的时候扮演的是一个打开其他组件的角色,比如启动Service,Notification提示, Activity等！
 *
 * Android 4.3以上的版本，是允许将程序安装到SD卡上的，假如你的程序是安装在SD上 的，就会收不到开机广播，具体原因以及解决方法下一节再详细讲解！
 *
 *
 * 在Android 4.3以上的版本，允许我们将应用安装在SD上，我们都知道是系统开机 间隔一小段时间后，才装载SD卡的，这样我们的应用就可能监听不到这个广播了！ 所以我们需要既监听开机广播又监听SD卡挂载广播！
 另外，有些手机可能并没有SD卡，所以这两个广播监听我们不能写到同一个Intetn-filter里 而是应该写成两个，配置代码如下：
 * <receiver android:name=".MyBroadcastReceiver">
 <intent-filter>
 <action android:name="android.intent.action.BOOT_COMPLETED"/>
 </intent-filter>
 <intent-filter>
 <action android:name="ANDROID.INTENT.ACTION.MEDIA_MOUNTED"/>
 <action android:name="ANDROID.INTENT.ACTION.MEDIA_UNMOUNTED"/>
 <data android:scheme="file"/>
 </intent-filter>
 </receiver>
 *
 * Created by louisgeek on 2016/5/19.
 */
public class BootCompleteBroadcastReceiver  extends BroadcastReceiver {

    private final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_BOOT.equals(intent.getAction())){
            Toast.makeText(context, "开机完毕~", Toast.LENGTH_LONG).show();
    }
    }
}

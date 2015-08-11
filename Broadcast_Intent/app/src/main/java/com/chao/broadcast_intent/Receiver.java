package com.chao.broadcast_intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by chao on 2015/4/9.
 */
public class Receiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        CharSequence sequence="收到广播消息";
        Toast.makeText(context,sequence,Toast.LENGTH_SHORT).show();
    }
}

package com.chao.broadcast_pj_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by chao on 2015/4/16.
 */
public class BroadcastRcceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "this is a broadcastreceiver", Toast.LENGTH_SHORT).show();

    }
}

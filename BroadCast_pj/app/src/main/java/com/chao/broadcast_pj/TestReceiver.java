package com.chao.broadcast_pj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by chao on 2015/4/16.
 */
public class TestReceiver extends BroadcastReceiver{
    public  TestReceiver(){
        System.out.println("TestReceiver");

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"this is a broadcastreceiver",Toast.LENGTH_SHORT).show();

    }
}

package com.chao.service_pj;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by chao on 2015/4/17.
 */
public class SreviceTest extends Service{
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);




    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestory",Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return null;

    }
}

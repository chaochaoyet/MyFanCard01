package com.chao.notification_test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button button;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification=new Notification(R.drawable.photo1,"加油",System.currentTimeMillis());
                Intent intent=new Intent();
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,0);
                notification.setLatestEventInfo(MainActivity.this,"小明加油","小明加油啊",pendingIntent);
                notificationManager.notify(1,notification);
            }
        });
    }



}

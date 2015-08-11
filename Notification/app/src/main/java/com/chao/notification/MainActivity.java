package com.chao.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio;
import android.view.View;
import android.widget.Button;

/***
 * @description 状态栏通知相关
 * @author chenzheng_java
 *
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.sunny_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addNotificaction();

            }
        });

    }




    /**
     * 添加一个notification
     */
    private void addNotificaction() {
        NotificationManager manager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        // 创建一个Notification
        Notification notification = new Notification();
        // 设置显示在手机最上边的状态栏的图标
        notification.icon = android.R.drawable.ic_delete;
        // 当当前的notification被放到状态栏上的时候，提示内容
        notification.tickerText = "注意了，我被扔到状态栏了";

        /***
         * notification.contentIntent:一个PendingIntent对象，当用户点击了状态栏上的图标时，该Intent会被触发
         * notification.contentView:我们可以不在状态栏放图标而是放一个view
         * notification.deleteIntent 当当前notification被移除时执行的intent
         * notification.vibrate 当手机震动时，震动周期设置
         */
        // 添加声音提示
        notification.defaults=Notification.DEFAULT_SOUND;
        // audioStreamType的值必须AudioManager中的值，代表着响铃的模式
        notification.audioStreamType= android.media.AudioManager.ADJUST_LOWER;

        //下边的两个方式可以添加音乐
        //notification.sound = Uri.parse("file:///sdcard/notification/ringer.mp3");
        //notification.sound = Uri.withAppendedPath(Audio.Media.INTERNAL_CONTENT_URI, "6");
        Intent intent = new Intent(this, Notification2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        // 点击状态栏的图标出现的提示信息设置
        notification.setLatestEventInfo(this, "内容提示：", "我就是一个测试文件", pendingIntent);
        manager.notify(1, notification);

    }

}

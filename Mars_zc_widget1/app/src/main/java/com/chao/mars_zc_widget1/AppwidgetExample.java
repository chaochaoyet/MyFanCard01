package com.chao.mars_zc_widget1;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by chao on 2015/5/11.
 */
public class AppwidgetExample extends AppWidgetProvider {
    private static final String UPDATE_WIDGET="mars_zc.appwidget.UPDATE_APPWIDGET";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(UPDATE_WIDGET.equals(action)){
            RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.appwidget);
            remoteViews.setImageViewResource(R.id.image,R.drawable.photo2);
            remoteViews.setTextViewText(R.id.text,"hello world");
            AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(context);
            //componentname代表整个appwidget，remoteview代表appwidget中的所有控件
            ComponentName componentName=new ComponentName(context,AppwidgetExample.class);
            appWidgetManager.updateAppWidget(componentName,remoteViews);
            System.out.println("Receive action--->"+action);
        }
        else


        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intent intent=new Intent(UPDATE_WIDGET);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intent,0);
        RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.appwidget);
        remoteViews.setOnClickPendingIntent(R.id.button,pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds,remoteViews);
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
}

package com.chao.mars_zc_appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by chao on 2015/5/11.
 */
public class ExampleAppWidgetProvider  extends AppWidgetProvider{
    private static final String UPDATE_WIDGET="mars_zc.appwidget.UPDATE_APPWIDGET";
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        System.out.println("onUpdate");
        for(int i=0;i<appWidgetIds.length;i++){
            Intent intent=new Intent(context,MainActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
            RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.appwidget_example);
            remoteViews.setOnClickPendingIntent(R.id.widget_button,pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds[i],remoteViews);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        System.out.println("onEnable");
        super.onEnabled(context);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        System.out.println("onDelete");
        super.onDeleted(context, appWidgetIds);

    }

    @Override
    public void onDisabled(Context context) {
        System.out.println("onDisable");
        super.onDisabled(context);
    }
}

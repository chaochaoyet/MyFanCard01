package com.tabhost_test;

import android.app.TabActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    private TabHost tabHost=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabHost=this.getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_main,tabHost.getTabContentView(),true);
        tabHost.addTab(tabHost.newTabSpec("1").setIndicator("主页").setContent(R.id.layout));
        tabHost.addTab(tabHost.newTabSpec("2").setIndicator("搜索").setContent(R.id.layout));
        tabHost.addTab(tabHost.newTabSpec("3").setIndicator("消息").setContent(R.id.layout));
        tabHost.addTab(tabHost.newTabSpec("").setIndicator("我").setContent(R.id.layout));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

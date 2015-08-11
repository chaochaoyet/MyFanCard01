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
        tabHost.addTab(tabHost.newTabSpec("1").setIndicator("��ҳ").setContent(R.id.layout));
        tabHost.addTab(tabHost.newTabSpec("2").setIndicator("����").setContent(R.id.layout));
        tabHost.addTab(tabHost.newTabSpec("3").setIndicator("��Ϣ").setContent(R.id.layout));
        tabHost.addTab(tabHost.newTabSpec("").setIndicator("��").setContent(R.id.layout));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

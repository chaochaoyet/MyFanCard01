package com.tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends TabActivity{
    private TabHost tab=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tab=this.getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_main, tab.getTabContentView(), true);
        tab.addTab(tab.newTabSpec("选项卡一").setIndicator("one"
               ).setContent(R.id.tab01));
        tab.addTab(tab.newTabSpec("选项卡二").setIndicator("two"
               ).setContent(R.id.tab02));
        tab.addTab(tab.newTabSpec("选项卡三").setIndicator("three"
               ).setContent(R.id.tab03));
    }
}

package com.tabhost_zc;

import android.R;
import android.app.TabActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity{
    private TabHost tabHost=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabHost=this.getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_main)


    
}

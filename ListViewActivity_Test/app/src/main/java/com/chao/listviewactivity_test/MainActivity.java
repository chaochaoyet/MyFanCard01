package com.chao.listviewactivity_test;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<HashMap<String,String>> groups=new ArrayList<HashMap<String, String>>();
        HashMap<String,String> group1=new HashMap<String,String>();
        group1.put("group","group1");
        HashMap<String,String> group2=new HashMap<String,String>();
        group2.put("group","group2");
        HashMap<String,String> group3=new HashMap<String,String>();
        group3.put("group","group3");

        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,groups,R.layout.item,new String[]{"group"},new int[]{R.id.item_text});
        setListAdapter(simpleAdapter);


    }



}

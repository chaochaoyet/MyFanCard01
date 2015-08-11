package com.chao.listview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private ListView listView;
    private ArrayList<MyList> list;
    private SelfAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        list=new ArrayList<MyList>();
        adapter=new SelfAdapter(this);
        list.add(new MyList("list_1"));
        list.add(new MyList("list_2"));
        list.add(new MyList("list_3"));
        list.add(new MyList("list_4"));
        list.add(new MyList("list_5"));
        list.add(new MyList("list_6"));
        list.add(new MyList("list_7"));
        adapter.setList(list);
        listView.setAdapter(adapter);
    }




}

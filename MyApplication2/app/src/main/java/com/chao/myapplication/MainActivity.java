package com.chao.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);

        ArrayList<HashMap<String,Object>> listitem=new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<6;i++){
            HashMap<String,Object> map=new HashMap<String, Object>();
            map.put("ItemImage",R.drawable.photo1);
            map.put("ItemTitle","第"+i+"行");
            map.put("ItemText","这是第"+i+"行");
            listitem.add(map);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listitem,R.layout.item,new String[]{"ImageItem","ItemTitle","ItemText"},
                new int[]{R.id.ItemImage,R.id.ItemTitle,R.id.ItemText});
        listView.setAdapter(simpleAdapter);
    }





}

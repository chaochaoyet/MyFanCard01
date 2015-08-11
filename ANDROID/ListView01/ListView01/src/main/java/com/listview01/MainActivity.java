package com.listview01;

import android.widget.SimpleAdapter;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends Activity {
    private ListView list = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.MyListView);

        //组织数据源
        List<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<10;i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("itemTitle", "This is Title");
            map.put("itemText", "This is text");
            mylist.add(map);
        }

        //配置适配器
        SimpleAdapter adapter = new SimpleAdapter(this,
                mylist,//数据源
                R.layout.myListView,//显示布局
                new String[] {"itemTitle", "itemText"}, //数据源的属性字段
                new int[] {R.id.itemTitle,R.id.itemText}); //布局里的控件id
        //添加并且显示
        list.setAdapter(adapter);
    }
}
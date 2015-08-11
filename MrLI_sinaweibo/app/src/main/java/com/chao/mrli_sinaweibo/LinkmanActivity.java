package com.chao.mrli_sinaweibo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chao on 2015/5/25.
 */
public class LinkmanActivity extends Activity{
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linkman);
        listView=(ListView)findViewById(R.id.linkman_list);
        ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
        HashMap<String,String> hashMap=new HashMap<String,String>();
        for(int i=0;i<10;i++){
            hashMap.put("linkman","张三");
            list.add(hashMap);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(LinkmanActivity.this,list,R.layout.linkmanlist_item,
                new String[]{"linkman"},new int[]{R.id.linkman_item});
        listView.setAdapter(simpleAdapter);


    }
}

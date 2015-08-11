package com.chao.mrli_sinaweibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chao on 2015/5/27.
 */
public class WeiboListActivity extends Activity{
    private Button back;
    private ListView listView;
    String weibo_str=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weibolist);
        final Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        weibo_str=bundle.getString("weibo_text");
        back=(Button)findViewById(R.id.back);
        listView=(ListView)findViewById(R.id.weibo_list);
        //List<String> list=new ArrayList<String>();
        //list.add(weibo_str);
        //ArrayAdapter arrayAdapter=new ArrayAdapter(WeiboListActivity.this,R.layout.weibolist_item,list);
        //listView.setAdapter(arrayAdapter);
        ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();
        HashMap<String,String> hashMap=new HashMap<String,String>();

        hashMap.put("text",weibo_str);
        list.add(hashMap);
        SimpleAdapter simpleAdapter=new SimpleAdapter(WeiboListActivity.this,list,R.layout.weibolist_item,
                new String[]{"text"},new int[]{R.id.weibolist_text});
        listView.setAdapter(simpleAdapter);
        Toast.makeText(WeiboListActivity.this,weibo_str,Toast.LENGTH_SHORT).show();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_to=new Intent(WeiboListActivity.this,EditWeioboActivity.class);
                startActivity(intent_to);
            }
        });
    }
}

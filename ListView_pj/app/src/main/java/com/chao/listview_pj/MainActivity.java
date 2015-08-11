package com.chao.listview_pj;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
        ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
        HashMap<String,String> hashMap=new HashMap<String,String>();
        for(int i=0;i<3;i++){
        hashMap.put("user","张三");
        hashMap.put("ip","192.168");
            list.add(hashMap);}

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.item,new String[]{"user","ip"},new int[]{R.id.text_user,R.id.text_ip});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Uri uri=Uri.parse("tel:1008611");
                    Intent intent=new Intent(Intent.ACTION_CALL,uri);
                    startActivity(intent);
                }
                else if(i==1){
                    Uri uri=Uri.parse("smsto:1008611");
                    Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
                    startActivity(intent);

                }
                else {
                    Intent intent=new Intent(MainActivity.this,Next.class);
                    intent.putExtra("zc","this is a test");
                    startActivity(intent);
                }
            }
        });
    }



}

package com.chao.weibo_layout;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {
    private TextView textView01,textView02;
    private ImageView imageView;
    private Button button1,button2,button3,button4,button5;

    RefreshableView refreshableView;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        textView01=(TextView)findViewById(R.id.textview01);
        textView02=(TextView)findViewById(R.id.textview02);
        imageView=(ImageView)findViewById(R.id.imageview);

        TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("主页",getResources().getDrawable(R.drawable.photo1)).setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("消息",getResources().getDrawable(R.drawable.photo2)).setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("搜索",getResources().getDrawable(R.drawable.photo3)).setContent(R.id.view3));
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("我",getResources().getDrawable(R.drawable.photo4)).setContent(R.id.view4));
        tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("更多",getResources().getDrawable(R.drawable.photo5)).setContent(R.id.view5));

        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        listView = (ListView) findViewById(R.id.list_view);
        final ArrayList<HashMap<String,Object>> hashMapList=new ArrayList<HashMap<String, Object>>();
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        for(int i=0;i<3;i++){
            hashMap.put("Title","Title");
            hashMap.put("Text","Text");
            hashMap.put("imageview",R.drawable.ic_launcher);


            hashMapList.add(hashMap);}
        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,hashMapList,R.layout.item,
                new String[] {"Title","Text","imageview"},new int[] {R.id.textview01,R.id.textview02,R.id.imageview});
        listView.setAdapter(simpleAdapter);

        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        }, 0);

    }

}
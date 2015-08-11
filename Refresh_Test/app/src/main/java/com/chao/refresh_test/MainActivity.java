package com.chao.refresh_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chao on 2015/5/25.
 */
public class MainActivity extends Activity{

    private ImageView imageView;
    private Button button1,button2,button3,button4,button5;
    //private TextView get_weibo_text;

    RefreshableView refreshableView;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
      
        list = (ListView) findViewById(R.id.lv);




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

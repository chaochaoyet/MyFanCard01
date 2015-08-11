package com.chao.mrli_sinaweibo;

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

import com.chao.ToolUtils.MyAdapter;
import com.chao.ToolUtils.RefreshableView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chao on 2015/5/25.
 */
public class HomeActivity extends Activity{

    private ImageView imageView;
    private Button button1,button2,button3,button4,button5;
    //private TextView get_weibo_text;

    RefreshableView refreshableView;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        //get_weibo_text=(TextView)findViewById(R.id.get_weibo_text);
        list = (ListView) findViewById(R.id.lv);
        MyAdapter adapter=new MyAdapter(this);
        list.setAdapter(adapter);
        list.setItemsCanFocus(false);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MyAdapter.ViewHolder vHollder = (MyAdapter.ViewHolder) view.getTag();
//在每次获取点击的item时将对于的checkbox状态改变，同时修改map的值。
                vHollder.cBox.toggle();
                MyAdapter.isSelected.put(position, vHollder.cBox.isChecked());
            }
        });
       // Intent intent=this.getIntent();
       // Bundle bundle=intent.getExtras();
       // String str=bundle.getString("weibo_text");
        //SimpleAdapter simpleAdapter=itemlist();
        /**
         *  ArrayList<HashMap<String,Object>> hashMapList=new ArrayList<HashMap<String, Object>>();
         HashMap<String,Object> hashMap=new HashMap<String, Object>();
         for(int i=0;i<10;i++){
         hashMap.put("text","");


         hashMapList.add(hashMap);}
         SimpleAdapter simpleAdapter=new SimpleAdapter(HomeActivity.this,hashMapList,R.layout.item,
         new String[] {"text"},new int[] {R.id.textview01});
         listView.setAdapter(simpleAdapter);
         */




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

    /**
     *   private SimpleAdapter itemlist(){
     final ArrayList<HashMap<String,Object>> hashMapList=new ArrayList<HashMap<String, Object>>();
     HashMap<String,Object> hashMap=new HashMap<String, Object>();
     for(int i=0;i<10;i++){
     hashMap.put("text",);


     hashMapList.add(hashMap);}
     SimpleAdapter simpleAdapter=new SimpleAdapter(HomeActivity.this,hashMapList,R.layout.item,
     new String[] {"text"},new int[] {R.id.textview01});
     return simpleAdapter;

     }
      * @return
     */



}


package com.chao.mrli_sinaweibo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.chao.ToolUtils.MyAdapter;
import com.chao.ToolUtils.RefreshableView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chao on 2015/5/25.
 */
public class MessageActivity extends Activity{
    RefreshableView refreshableView1;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

          refreshableView1=(RefreshableView)findViewById(R.id.refreshable_view1);
          listView=(ListView)findViewById(R.id.message_list);
          listView.setDivider(null);
        /**
         *   MyAdapter adapter=new MyAdapter(this);
         listView.setAdapter(adapter);
         listView.setItemsCanFocus(false);
         listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
        MyAdapter.ViewHolder vHollder = (MyAdapter.ViewHolder) view.getTag();
        //在每次获取点击的item时将对于的checkbox状态改变，同时修改map的值。
        vHollder.cBox.toggle();
        MyAdapter.isSelected.put(position, vHollder.cBox.isChecked());
        }
        });
         */

        ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("message","暂时还没有消息哦...");
        list.add(hashMap);
        SimpleAdapter simpleAdapter=new SimpleAdapter(MessageActivity.this,list,R.layout.messagelist_item,
                new String[]{"message"},new int[]{R.id.message_item});
        listView.setAdapter(simpleAdapter);

         refreshableView1.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
        @Override
        public void onRefresh() {
        try {
        Thread.sleep(3000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        refreshableView1.finishRefreshing();
        }
        }, 0);



    }

}

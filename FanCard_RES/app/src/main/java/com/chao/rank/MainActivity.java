package com.chao.rank;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {
    private int rank[]={12,13,23,12,55,90,33,0,2};
    private int max;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);
        for(int j=1;j<rank.length;j++){
           for(int i=1;i<rank.length;i++){
               if(rank[i-1]<rank[i]){
                   max=rank[i];
                   rank[i]=rank[i-1];
                   rank[i-1]=max;
               }
           }
        }
        for(int n=0;n<rank.length;n++){
           System.out.println("this is -->"+rank[n]);
        }
        ArrayList<HashMap<String,Object>> list=new ArrayList<>();

        for(int m=0;m<rank.length;m++){
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("rank",rank[m]);
            list.add(hashMap);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,list,R.layout.item,new String[]{"rank"},new int[]{R.id.text});
        listView.setAdapter(simpleAdapter);




    }



}

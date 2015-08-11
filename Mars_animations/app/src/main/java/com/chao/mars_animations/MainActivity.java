package com.chao.mars_animations;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView listView;
    private Button button;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        button=(Button)findViewById(R.id.button);
        relativeLayout=(RelativeLayout)findViewById(R.id.layout);

        relativeLayout.setLayoutAnimation(buildAnimationController());
        listView.setLayoutAnimation(buildAnimationController());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleAdapter simpleAdapter=buildAdapter();
                listView.setAdapter(simpleAdapter);



            }
        });


    }
    public SimpleAdapter buildAdapter(){
        List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
        HashMap<String,String> hashMap1=new HashMap<String,String>();
        hashMap1.put("name","张三");
        hashMap1.put("gender","男");
        HashMap<String,String> hashMap2=new HashMap<String,String>();
        hashMap2.put("name","李四");
        hashMap2.put("gender","男");
        HashMap<String,String> hashMap3=new HashMap<String,String>();
        hashMap3.put("name","小雨");
        hashMap3.put("gender","女");
        list.add(hashMap1);
        list.add(hashMap2);
        list.add(hashMap3);
        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,list,R.layout.item,new String[]{"name","gender"},new int[]{R.id.name,R.id.gender});
       return simpleAdapter;

    }
    private LayoutAnimationController buildAnimationController(){
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.list_anim);
        LayoutAnimationController layoutAnimationController=new LayoutAnimationController(animation);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        layoutAnimationController.setDelay(0.5f);
        return layoutAnimationController;
    }




}

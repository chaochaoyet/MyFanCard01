package com.chao.mars_zc_expandlistview;

import android.app.ExpandableListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ExpandableListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<HashMap<String,String>> groups=new ArrayList<HashMap<String, String>>();
        HashMap<String,String> group1=new HashMap<String,String>();
        group1.put("group","group1");
        HashMap<String,String> group2=new HashMap<String,String>();
        group2.put("group","group2");
        HashMap<String,String> group3=new HashMap<String,String>();
        group3.put("group","group3");

        groups.add(group1);
        groups.add(group2);
        groups.add(group3);


        List<HashMap<String,String >> child1=new ArrayList<HashMap<String, String>>();
        HashMap<String,String> child1data1=new HashMap<String,String>();
        child1data1.put("child","child1data1");
        HashMap<String,String > child1data2=new HashMap<String,String>();
        child1data2.put("child","child1data2");
        HashMap<String,String > child1data3=new HashMap<String,String>();
        child1data3.put("child","child1data3");

        child1.add(child1data1);
        child1.add(child1data2);
        child1.add(child1data3);


        List<HashMap<String,String>> child2=new ArrayList<HashMap<String,String>>();
        HashMap<String,String> child2data1=new HashMap<String,String >();
        child2data1.put("child","child2data1");
        HashMap<String,String> child2data2=new HashMap<String,String >();
        child2data2.put("child","child2data2");

        child2.add(child2data1);
        child2.add(child2data2);


        List<HashMap<String,String>> child3=new ArrayList<HashMap<String,String>>();
        HashMap<String,String> child3data1=new HashMap<String,String >();
        child3data1.put("child","child3data1");
        HashMap<String,String> child3data2=new HashMap<String,String >();
        child3data2.put("child","child3data2");

        child3.add(child3data1);
        child3.add(child3data2);



        List<List<HashMap<String,String>>> childs=new ArrayList<List<HashMap<String,String>>>();
        childs.add(child1);
        childs.add(child2);
        childs.add(child3);

        List<HashMap<String,String >> child_child=new ArrayList<HashMap<String, String>>();
        HashMap<String,String> child_child_data=new HashMap<String,String>();
        child_child_data.put("child_child","child_child_data");
        child_child.add(child_child_data);

        SimpleExpandableListAdapter simpleExpandableListAdapter=new SimpleExpandableListAdapter(MainActivity.this,groups,R.layout.group,new String[]{
                "group"},new int[]{R.id.group_text},childs,R.layout.child,new String[]{"child"},new int[]{R.id.child_text});
        setListAdapter(simpleExpandableListAdapter);
    }



}

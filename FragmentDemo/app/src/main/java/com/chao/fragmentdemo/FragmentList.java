package com.chao.fragmentdemo;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chao on 2015/7/20.
 */
public class FragmentList extends ListFragment{
    private String[] values = new String[] { "侏儒", "人类", "暗夜精灵", "矮人", "德莱尼",
            "狼人" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<HashMap<String,Object>> list=new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<values.length;i++){
            HashMap<String,Object> hashMap=new HashMap<String,Object>();
            hashMap.put("name",values[i]);
            list.add(hashMap);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),list,R.layout.list_item,new String[]{"name"},new int[]{R.id.list_text});
        setListAdapter(simpleAdapter);
    }


}

package com.listview01;

import android.widget.SimpleAdapter;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends Activity {
    private ListView list = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.MyListView);

        //��֯����Դ
        List<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<10;i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("itemTitle", "This is Title");
            map.put("itemText", "This is text");
            mylist.add(map);
        }

        //����������
        SimpleAdapter adapter = new SimpleAdapter(this,
                mylist,//����Դ
                R.layout.myListView,//��ʾ����
                new String[] {"itemTitle", "itemText"}, //����Դ�������ֶ�
                new int[] {R.id.itemTitle,R.id.itemText}); //������Ŀؼ�id
        //��Ӳ�����ʾ
        list.setAdapter(adapter);
    }
}
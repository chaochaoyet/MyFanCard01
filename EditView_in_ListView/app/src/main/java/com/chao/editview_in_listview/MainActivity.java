package com.chao.editview_in_listview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chao.ToolUtils.MyAdapter;


public class MainActivity extends Activity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.lv);
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
    }



}

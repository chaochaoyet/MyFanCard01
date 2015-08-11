package com.chao.use_list02;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class MainActivity extends ActionBarActivity {
    private ListView listView;
    private TextView textView01,textView02;
    private ImageView imageView;
    private EditText editText;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        textView01=(TextView)findViewById(R.id.textview01);
        textView02=(TextView)findViewById(R.id.textview02);
        imageView=(ImageView)findViewById(R.id.imageview);




        final ArrayList<HashMap<String,Object>> hashMapList=new ArrayList<HashMap<String, Object>>();
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        for(int i=0;i<5;i++){
        hashMap.put("Title","Title");
        hashMap.put("Text","Text");
        hashMap.put("imageview",R.drawable.ic_launcher);


        hashMapList.add(hashMap);}
        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,hashMapList,R.layout.list_item,
                new String[] {"Title","Text","imageview"},new int[] {R.id.textview01,R.id.textview02,R.id.imageview});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"this is "+(i+1)+" row",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

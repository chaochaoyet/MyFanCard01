package com.chao.button_in_listview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listView);
        MyAdapter myAdapter=new MyAdapter(MainActivity.this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"zchello"+i,Toast.LENGTH_SHORT).show();
                TextView textView=new TextView(MainActivity.this);
                textView.setText("是否查看详情");
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.head_1)
                        .setTitle("详情查看")
                        .setView(textView)
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(MainActivity.this,"正常退出",Toast.LENGTH_SHORT).show();
                                        /**
                                         *    View dialogView=View.inflate(MainActivity.this,R.layout.dialog,null);
                                         Dialog dialog=new Dialog(MainActivity.this,R.style.dialog_style);
                                         dialog.setContentView(dialogView);
                                         dialog.show();
                                         Button button=(Button)dialogView.findViewById(R.id.oauth);
                                         button.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                        MainActivity.this.finish();

                                        }
                                        });
                                          */
                                     finish();


                                    }
                                }).create().show();
            }
        });
    }




}

package com.chao.layoutinflaterdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }



    public void showDialog(){
        AlertDialog.Builder builder;
        AlertDialog alertDialog;
        Context mContext=MainActivity.this;
        //LayoutInflater inflater=getLayoutInflater();
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout=inflater.inflate(R.layout.dialog,null);
        TextView textView=(TextView)layout.findViewById(R.id.text);
        textView.setText("hello");
        ImageView imageView=(ImageView)layout.findViewById(R.id.image);
        imageView.setImageResource(R.drawable.ic_launcher);
        builder=new AlertDialog.Builder(mContext);
        builder.setView(layout);
        alertDialog=builder.create();
        alertDialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return true;
    }



}

package com.chao.sqlite_pj;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this,"this is a databasehelper");
                SQLiteDatabase sqLiteDatabase=databaseHelper.getReadableDatabase();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values=new ContentValues();
                values.put("id",1);
                values.put("name","张三");
                DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this,"this is a databasehelper");
                SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
                sqLiteDatabase.insert("user",null,values);

            }
        });
    }



}

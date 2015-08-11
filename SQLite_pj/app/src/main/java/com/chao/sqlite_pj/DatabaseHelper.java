package com.chao.sqlite_pj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chao on 2015/4/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    private static final  int VERSION=1;
    public DatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory cursorFactory,int version){
        super(context,name,cursorFactory,version);
    }
    public DatabaseHelper(Context context,String name){
        this(context,name,VERSION);
    }
    public  DatabaseHelper(Context context,String name,int version){
        this(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("Create a Database");
        sqLiteDatabase.execSQL("create table user(id int,name varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        System.out.println("update a Database");
    }
}

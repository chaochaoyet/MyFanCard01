package com.chao.ToolUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chao.DataUtils.DBInfo;

/**
 * Created by chao on 2015/5/20.
 */
public class SqlHelper extends SQLiteOpenHelper {
    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public SqlHelper(Context context){
        this(context, DBInfo.DB.DB_NAME, null, DBInfo.DB.VERSON);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBInfo.Table.CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL(DBInfo.Table.DROP_USER_TABLE);
        onCreate(sqLiteDatabase);


    }
}

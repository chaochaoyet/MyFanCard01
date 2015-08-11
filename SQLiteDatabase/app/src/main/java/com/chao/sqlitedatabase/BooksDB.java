package com.chao.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chao on 2015/6/17.
 */
public class BooksDB extends SQLiteOpenHelper {
    private final static String DATABASE_NAME="BOOKS.db";
    private final static int DATABASE_VERSION=1;
    private final static String TABLE_NAME="books_table";
    private final static String BOOK_ID="book_id";
    private final static String BOOK_NAME="book_name";
    private final static String BOOK_AUTHOR="book_author";

    public BooksDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + BOOK_ID
                + " INTEGER primary key autoincrement, " + BOOK_NAME + " text, "+  BOOK_AUTHOR +" text);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }


    public Cursor select(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.query(TABLE_NAME,null,null,null,null,null,null);
        return cursor;
    }

    public long insert(String bookname,String author){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(BOOK_NAME,bookname);
        contentValues.put(BOOK_AUTHOR,author);
        long row=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return row;
    }

    public void delete(int id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String where=BOOK_ID+" = ?";
        String[] whereValue={Integer.toString(id)};
        sqLiteDatabase.delete(TABLE_NAME,where,whereValue);
    }

    public void update(int id,String bookname,String author){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String where=BOOK_ID+" =?";
        String[] whereValue={Integer.toString(id)};

        ContentValues contentValues=new ContentValues();
        contentValues.put(BOOK_NAME,bookname);
        contentValues.put(BOOK_AUTHOR,author);

        sqLiteDatabase.update(TABLE_NAME,contentValues,where,whereValue);
    }
}

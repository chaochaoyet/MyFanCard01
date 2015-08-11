package com.chao.ToolUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.chao.DataUtils.DBInfo;
import com.chao.DataUtils.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chao on 2015/5/20.
 */
public class UserDao {
    private SqlHelper sqlHelper=null;
    private SQLiteDatabase sqLiteDatabase=null;
    String[] columns={DBInfo.Table._ID,DBInfo.Table.USER_ID,DBInfo.Table.USER_NAME,
            DBInfo.Table.TOKEN,DBInfo.Table.TOKEN_SECRET,DBInfo.Table.DESCRIPTION,DBInfo.Table.USER_HEAD};
    public UserDao(Context context){
        sqlHelper=new SqlHelper(context);
    }
    /**
     * 添加用户
     * @return
     */
    public long inserUser(User user){
        sqLiteDatabase=sqlHelper.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(DBInfo.Table.USER_ID,user.getUser_id());
        values.put(DBInfo.Table.USER_NAME,user.getUser_name());
        values.put(DBInfo.Table.TOKEN,user.getToken());
        values.put(DBInfo.Table.TOKEN_SECRET,user.getToken_secret());
        values.put(DBInfo.Table.DESCRIPTION,user.getDescription());

        //将图片进行转化，存储
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        BitmapDrawable newhead=(BitmapDrawable)user.getUser_head();
        //将图片压缩成PNG编码数据
        newhead.getBitmap().compress(Bitmap.CompressFormat.PNG,100,outputStream);


        values.put(DBInfo.Table.USER_HEAD,outputStream.toByteArray());

        long rowId=sqLiteDatabase.insert(DBInfo.Table.USER_TABLE,DBInfo.Table.USER_NAME,values);
        sqLiteDatabase.close();
        return rowId;
    }

    /**
     * 更新用户
     * @return
     */
    public int updateUser(){
        return 1;
    }

    /**
     * 删除用户
     * @return
     */
    public  int deleteUser(){
        return 1;
    }

    /**
     * 根据ID查找用户
     * @param user_id
     * @return
     */
    public User findUserByUserId(String  user_id){
        return null;
    }

    /**
     * 查找所有用户
     * @return
     */

    public List<User> findAllUsers(){
        sqLiteDatabase=sqlHelper.getReadableDatabase();
        List<User> userList=null;

        Cursor cursor=sqLiteDatabase.query(DBInfo.Table.USER_TABLE, columns, null, null, null, null, null);
        if(cursor!=null && cursor.getCount()>0){
            userList=new ArrayList<User>();
            while(cursor.moveToNext()){
                User user=new User();
                user.setId(cursor.getLong(cursor.getColumnIndex(DBInfo.Table._ID)));
                user.setUser_id(cursor.getString(cursor.getColumnIndex(DBInfo.Table.USER_ID)));
                user.setUser_name(cursor.getString(cursor.getColumnIndex(DBInfo.Table.USER_NAME)));
                user.setToken(cursor.getString(cursor.getColumnIndex(DBInfo.Table.TOKEN)));
                user.setToken_secret(cursor.getString(cursor.getColumnIndex(DBInfo.Table.TOKEN_SECRET)));
                user.setDescription(cursor.getString(cursor.getColumnIndex(DBInfo.Table.DESCRIPTION)));
                byte[] bytehead=cursor.getBlob(cursor.getColumnIndex(DBInfo.Table.USER_HEAD));
                ByteArrayInputStream inputStream=new ByteArrayInputStream(bytehead);
                Drawable userhead=Drawable.createFromStream(inputStream,"image");
                user.setUser_head(userhead);
                userList.add(user);

            }

        }
        cursor.close();
        sqLiteDatabase.close();

        return userList;
    }
}

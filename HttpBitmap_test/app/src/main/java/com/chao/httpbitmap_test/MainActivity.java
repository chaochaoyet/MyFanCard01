package com.chao.httpbitmap_test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {
    private ImageView imageView;
    private final static String url="http://tp4.sinaimg.cn/3896259479/50/0/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.image);
        try{
            byte[] data = ImageService.getImage(url);
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            imageView.setImageBitmap(bitmap);//显示图片
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"异常",Toast.LENGTH_SHORT).show();
        }

    }




}

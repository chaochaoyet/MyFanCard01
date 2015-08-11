package com.chao.imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
    private ImageView imageView;
    private Button zoomout_button,zoomin_button,left_button,right_button;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageview);
        zoomout_button=(Button)findViewById(R.id.zoomout);
        zoomin_button=(Button)findViewById(R.id.zoomin);
        left_button=(Button)findViewById(R.id.left);
        right_button=(Button)findViewById(R.id.right);
        bitmap= BitmapFactory.decodeResource(this.getResources(),R.drawable.ic_launcher);
        imageView.setImageBitmap(bitmap);
        zoomout_button.setOnClickListener(this);
        zoomout_button.setTag(1);
        zoomin_button.setOnClickListener(this);
        zoomin_button.setTag(2);
        left_button.setOnClickListener(this);
        left_button.setTag(3);
        right_button.setOnClickListener(this);
        right_button.setTag(4);




    }
    @Override
    public void onClick(View view) {
        int tag=(Integer) view.getTag();
        switch (tag){
            case 1:
                {Toast.makeText(MainActivity.this,"正在放大...",Toast.LENGTH_SHORT).show();

                ZoomoutImageView(2,2);
                break;}
            case 2:
                 {Toast.makeText(MainActivity.this,"正在缩小...",Toast.LENGTH_SHORT).show();
                 ZoominImageView((float)0.5,(float)0.5);
                 break;}
            case 3:
                 { Toast.makeText(MainActivity.this,"正在左转...",Toast.LENGTH_SHORT).show();
                 RotateLeftImageView();
                 break;}
            case 4:
                { Toast.makeText(MainActivity.this,"正在右转...",Toast.LENGTH_SHORT).show();
                RotateRightImageView();
                break;}
            default:
                break;
        }

    }
    private void ZoomoutImageView(float width,float height){
        float scaleWidth=width;
        float scaleHeight=height;
        int bitmapWidth=bitmap.getWidth();
        int bitmapHeight=bitmap.getHeight();
        try
        {
            Matrix matrix=new Matrix();
            matrix.postScale(scaleWidth,scaleHeight);
            Bitmap resizeBmp=Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,matrix,true);
            imageView.setImageBitmap(resizeBmp);
            bitmap=resizeBmp;

        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,"放大图片产生的异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {

        }
    }
    private void ZoominImageView(float width,float height){
        float scaleWidth=width;
        float scaleHeight=height;
        int bitmapWidth=bitmap.getWidth();
        int bitmapHeight=bitmap.getHeight();
        try {
            Matrix matrix=new Matrix();
            matrix.postScale(scaleWidth,scaleHeight);
            Bitmap resizeBmp=Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,matrix,true);
            imageView.setImageBitmap(resizeBmp);
            bitmap=resizeBmp;
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,"缩小图片产生的异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {

        }
    }
    private void RotateLeftImageView(){
        int bitmapWidth=bitmap.getWidth();
        int bitmapHeight=bitmap.getHeight();
        try {
            Matrix matrix=new Matrix();
            matrix.postScale(1,1);
            matrix.setRotate(-90);
            Bitmap resizeBmp=Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,matrix,true);
            imageView.setImageBitmap(resizeBmp);
            bitmap=resizeBmp;
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,"左转图片产生的异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {

        }
    }
    private void RotateRightImageView(){
        int bitmapWidth=bitmap.getWidth();
        int bitmapHeight=bitmap.getHeight();
        try {
            Matrix matrix=new Matrix();
            matrix.postScale(1,1);
            matrix.setRotate(90);
            Bitmap resizeBmp=Bitmap.createBitmap(bitmap,0,0,bitmapWidth,bitmapHeight,matrix,true);
            imageView.setImageBitmap(resizeBmp);
            bitmap=resizeBmp;
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,"右转图片产生的异常"+e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {

        }
    }











}

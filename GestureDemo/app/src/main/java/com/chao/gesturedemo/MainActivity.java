package com.chao.gesturedemo;

import android.app.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnTouchListener,GestureDetector.OnGestureListener{
    private ImageView image;
    private GestureDetector mGestureDetector=new GestureDetector(this);
    private static final int FLING_MIN_DISTANCE = 120;//移动最小距离
    private static final int FLING_MIN_VELOCITY = 200;//移动最大速度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.image);
        image.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        image.setLongClickable(true);
        return mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        //Toast.makeText(MainActivity.this,"onDown",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
       // Toast.makeText(MainActivity.this,"onShowPress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
       // Toast.makeText(MainActivity.this,"onSingleTapUp",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v2) {
        if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                && Math.abs(v) > FLING_MIN_VELOCITY) {

            // Fling left
            Toast.makeText(this, "Fling Left", Toast.LENGTH_SHORT).show();
        } else
        if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                && Math.abs(v) > FLING_MIN_VELOCITY) {

            // Fling right
            Toast.makeText(this, "Fling Right", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        //Toast.makeText(MainActivity.this,"onLongPress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        //Toast.makeText(MainActivity.this,"onScroll",Toast.LENGTH_SHORT).show();
        return false;
    }
}

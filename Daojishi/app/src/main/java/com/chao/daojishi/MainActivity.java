package com.chao.daojishi;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends ActionBarActivity {
    private TextView textView;
    int minute=1;
    int second=31;
    int length=91;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        handler.postDelayed(runnable,1000);



    }
    Handler handler=new Handler();

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            length--;
            second--;
            if(second>0){   textView.setText(minute+":"+second);}
            else {textView.setText(length+"");}
            if(length<0){textView.setText("OVER");}





            handler.postDelayed(this,1000);
        }
    };
    /**
     *  private TextView textView;
     private int recLen=11;
     Timer timer=new Timer();

     @Override
     protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     textView=(TextView)findViewById(R.id.text);
     timer.schedule(task,1000,1000);
     }
     TimerTask task = new TimerTask() {
     @Override
     public void run() {

     runOnUiThread(new Runnable() {      // UI thread
     @Override
     public void run() {
     recLen--;
     textView.setText(""+recLen);
     if(recLen < 0){
     timer.cancel();
     textView.setVisibility(View.GONE);
     }
     }
     });
     }
     };


     */

}

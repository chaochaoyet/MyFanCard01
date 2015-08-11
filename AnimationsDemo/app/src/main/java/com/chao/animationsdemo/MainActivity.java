package com.chao.animationsdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends ActionBarActivity implements Runnable{
    private ImageView ball_one,ball_two,ball_three;
    private Handler handler;
    private LinearLayout target;
    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ball_one=(ImageView)findViewById(R.id.ball_one);
        ball_two=(ImageView)findViewById(R.id.ball_two);
        ball_three=(ImageView)findViewById(R.id.ball_three);
        target=(LinearLayout)findViewById(R.id.target);
        objectAnimator=new ObjectAnimator();
        performAnimate();


        ball_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator.ofFloat(target,"TranslationY",0,1000).setDuration(5000).start();
                try {
                    handler.wait(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        ball_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator.ofFloat(target,"TranslationY",0,1000).setDuration(5000).start();
                try {
                    handler.wait(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        ball_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator.ofFloat(target,"TranslationY",0,1000).setDuration(5000).start();
                try {

                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void run() {
        try {
            for(int i=0;i<3;i++){

                handler.sendMessage(handler.obtainMessage(100));
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void performAnimate(){

        handler=new android.os.Handler(){
            public void handleMessage(Message msg) {
            ObjectAnimator.ofFloat(target,"TranslationY",0,1000).setDuration(5000).start();
            }
        };
        new Thread(this).start();



    }



}

package com.chao.animationsdemoone;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private ImageView ball;
    private ObjectAnimator objectAnimator;
    private Handler handler;
    private Runnable runnable;
    private Thread thread;
    private boolean isTrue=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ball=(ImageView)findViewById(R.id.ball);
        objectAnimator=ObjectAnimator.ofFloat(ball,"TranslationY",1000,0).setDuration(5000);
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(isTrue){
                    handler.sendMessage(handler.obtainMessage(100));
                    Thread.sleep(6000);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
               objectAnimator.start();
            }
        };
        thread.start();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);

               // ball.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this,"start",Toast.LENGTH_SHORT).show();
                System.out.println(isTrue+"start");

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                Toast.makeText(MainActivity.this,"over",Toast.LENGTH_SHORT).show();
               // ball.setVisibility(View.GONE);

                System.out.println(isTrue + "over");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                isTrue=true;
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {

                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                isTrue=true;
                super.onAnimationResume(animation);
            }
        });
       ball.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               try{
                   Thread.sleep(1000);
                   isTrue=false;
                   objectAnimator.cancel();
                   //objectAnimator.end();
                   System.out.println("intrue-->"+isTrue);
                  // objectAnimator.start();
                  // isTrue=true;
               }
               catch (Exception e){
                   e.printStackTrace();
               }
           }
       });






    }



}

package com.chao.mars_animationset;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    private ImageView image;
    private Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.image);
        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new buttonClickListener());
        button1.setOnClickListener(new button1ClickListener());
    }
    private class buttonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Animation animation1= AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_rotate);
            animation1.setDuration(3000);
            animation1.setRepeatCount(2);
            image.startAnimation(animation1);

        }
    }
    private class button1ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AnimationSet animationSet=new AnimationSet(true);
            AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
            RotateAnimation rotateAnimation=new RotateAnimation(0,900,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(rotateAnimation);
            animationSet.setDuration(3000);
            animationSet.setRepeatCount(2);
            image.startAnimation(animationSet);
        }
    }



}

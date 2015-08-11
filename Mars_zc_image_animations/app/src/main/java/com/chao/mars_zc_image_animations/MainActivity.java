package com.chao.mars_zc_image_animations;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    private ImageView imageView;
    private Button alpha,scale,rotate_self,translate,rotate_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.image);
        alpha=(Button)findViewById(R.id.alpha);
        scale=(Button)findViewById(R.id.scale);
        rotate_self=(Button)findViewById(R.id.rotate_self);
        rotate_parent=(Button)findViewById(R.id.rotate_parent);
        translate=(Button)findViewById(R.id.translate);
        translate.setOnClickListener(new translateOnClickListener());
        rotate_parent.setOnClickListener(new rotateparentOnClickListener());
        rotate_self.setOnClickListener(new rotateselfOnClickListener());
        scale.setOnClickListener(new scaleOnClickListener());
        alpha.setOnClickListener(new alphaOnClickListener());
    }
    public class translateOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AnimationSet animationSet=new AnimationSet(true);
            TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-1f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,1f);
            translateAnimation.setRepeatCount(2);
            animationSet.addAnimation(translateAnimation);
            animationSet.setDuration(1000);



            imageView.startAnimation(animationSet);

        }
    }
    public class rotateselfOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AnimationSet animationSet=new AnimationSet(true);
            RotateAnimation rotateAnimation=new RotateAnimation(0,900, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            rotateAnimation.setRepeatCount(2);
            animationSet.addAnimation(rotateAnimation);
            animationSet.setDuration(3000);
            animationSet.setFillAfter(true);
            animationSet.setFillBefore(false);
            imageView.startAnimation(animationSet);

        }
    }
    public class rotateparentOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AnimationSet animationSet=new AnimationSet(true);
            RotateAnimation rotateAnimation=new RotateAnimation(0,360, Animation.RELATIVE_TO_PARENT,1f,Animation.RELATIVE_TO_PARENT,0f);

            animationSet.addAnimation(rotateAnimation);
            animationSet.setDuration(1000);
            animationSet.setFillAfter(true);
            animationSet.setFillBefore(false);
            imageView.startAnimation(animationSet);

        }
    }
    public class scaleOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AnimationSet animationSet=new AnimationSet(true);
            ScaleAnimation scaleAnimation=new ScaleAnimation(1,2f,1,2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(1000);
            animationSet.setFillAfter(true);
            animationSet.setFillBefore(false);
            imageView.startAnimation(animationSet);

        }
    }
    public class alphaOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AnimationSet animationSet=new AnimationSet(true);
            AlphaAnimation alphaAnimation=new AlphaAnimation(1,0);

            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(1000);
            animationSet.setFillAfter(true);
            animationSet.setFillBefore(false);
            imageView.startAnimation(animationSet);
        }
    }



}

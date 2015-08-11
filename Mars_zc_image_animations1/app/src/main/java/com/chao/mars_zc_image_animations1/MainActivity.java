package com.chao.mars_zc_image_animations1;

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
            Animation animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate);
            imageView.startAnimation(animation);


        }
    }
    public class rotateselfOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Animation animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
            imageView.startAnimation(animation);


        }
    }
    public class rotateparentOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Animation animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_parent);
            imageView.startAnimation(animation);

        }
    }
    public class scaleOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Animation animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
            imageView.startAnimation(animation);


        }
    }
    public class alphaOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
            imageView.startAnimation(animation);
        }
    }
}

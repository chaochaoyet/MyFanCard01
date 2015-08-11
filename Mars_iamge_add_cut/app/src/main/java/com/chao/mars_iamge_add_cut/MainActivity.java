package com.chao.mars_iamge_add_cut;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private ImageView iamge;
    private Button add_button,cut_button;
    private ViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iamge=(ImageView)findViewById(R.id.image);
        add_button=(Button)findViewById(R.id.add_button);
        cut_button=(Button)findViewById(R.id.cut_button);
        viewGroup=(ViewGroup)findViewById(R.id.viewgroup);
        add_button.setOnClickListener(new addClickListener());
        cut_button.setOnClickListener(new cutClickListener());
    }
    private class addClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
            alphaAnimation.setRepeatCount(2);
            alphaAnimation.setDuration(3000);
            ImageView imageView=new ImageView(MainActivity.this);
            imageView.setImageResource(R.drawable.ic_launcher);
            TextView textView=new TextView(MainActivity.this);
            textView.setText("hello");

            viewGroup.addView(imageView,new ViewGroup.LayoutParams(400,400));
            viewGroup.addView(textView);

            imageView.startAnimation(alphaAnimation);
            textView.startAnimation(alphaAnimation);

        }
    }
    private class cutClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
            alphaAnimation.setRepeatCount(2);
            alphaAnimation.setDuration(3000);
            //alphaAnimation.setAnimationListener(new cutAnimationListener());
            iamge.startAnimation(alphaAnimation);
            viewGroup.removeView(iamge);
        }

    }
    private class cutAnimationListener implements Animation.AnimationListener{
        public cutAnimationListener() {
            super();
        }

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            viewGroup.removeView(iamge);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }




}

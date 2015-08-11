package com.chao.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
    private Button button,button1,button2,button3;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        linearLayout=(LinearLayout)findViewById(R.id.ll);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


        /**
         *  button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(final View view) {

        ValueAnimator animator=ValueAnimator.ofFloat(0f,1000f);
        animator.setTarget(view);
        animator.setDuration(1000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        view.setTranslationY((float)valueAnimator.getAnimatedValue());
        }
        });

        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(view, "translationY", 0f, 1000f);
        objectAnimator.setRepeatCount(2);
        objectAnimator.setRepeatMode(Animation.RESTART);
        objectAnimator.setDuration(5000);
        objectAnimator.start();

        }
        });
         */


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                /**
                 * 简单动画
                 *
                 */
                ObjectAnimator.ofInt(button, "height", 0, 500).setDuration(5000).start();

                ObjectAnimator.ofInt(button, "width", 500).setDuration(5000).start();
                ObjectAnimator.ofFloat(button, "rotationX", 0.0f, 1800.0f).setDuration(5000).start();

                ObjectAnimator.ofFloat(button, "rotationY", 0.0f, 1800.0f).setDuration(5000).start();

                /**
                 * 手动添加属性
                 *  ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(view,"zhang",1.0f,0.0f).setDuration(1000);
                 objectAnimator.start();
                 objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float cVa1=(Float)valueAnimator.getAnimatedValue();
                view.setAlpha(cVa1);
                view.setScaleX(cVa1);
                view.setScaleY(cVa1);
                }
                });
                 */
                /**
                 *PropertyValuesHolder操作
                 * PropertyValuesHolder propertyValuesHolderX=PropertyValuesHolder.ofFloat("alpha",1f,0f,1f);
                 PropertyValuesHolder propertyValuesHolderY=PropertyValuesHolder.ofFloat("scaleX",1f,0f,1f);
                 PropertyValuesHolder propertyValuesHolderZ=PropertyValuesHolder.ofFloat("scaleY",1f,0f,1f);
                 ObjectAnimator.ofPropertyValuesHolder(view,propertyValuesHolderX,propertyValuesHolderY,propertyValuesHolderZ).setDuration(1000).start();

                 */

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(linearLayout, "translationY", 0f, 1000f);
                objectAnimator.setRepeatCount(3);
                objectAnimator.setRepeatMode(Animation.RESTART);
                objectAnimator.setDuration(5000);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationRepeat(Animator animation) {

                        super.onAnimationRepeat(animation);

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        
                        super.onAnimationEnd(animation);
                    }
                });

                objectAnimator.start();
                break;
        }
    }

}

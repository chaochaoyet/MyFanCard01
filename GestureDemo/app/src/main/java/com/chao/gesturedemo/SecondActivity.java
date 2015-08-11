package com.chao.gesturedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by chao on 2015/7/7.
 */
public class SecondActivity extends Activity implements GestureDetector.OnGestureListener{
    private GestureDetector detector;
    private ViewFlipper flipper;
    private int i=0;
    private int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        flipper=(ViewFlipper)findViewById(R.id.ViewFlipper01);
        flipper.addView(addButtonByText("按钮"),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        detector=new GestureDetector(this);
    }
    private View addButtonByText(String text){
        Button btn=new Button(this);
        btn.setText(text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        return btn;
    }
    private View addTextByText(String text){
        TextView tv=new TextView(this);
        tv.setText(text);
        tv.setGravity(1);
        return tv;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        if(motionEvent.getX()-motionEvent2.getX()>120 && i<4){
            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_left_out));
            this.flipper.addView(addTextByText("文本框"+(j++)),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            this.flipper.showNext();
            i++;
            return true;
        }
        else if (motionEvent.getX() - motionEvent2.getX() < -120 && i>0) {
            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_in));
            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_out));

            this.flipper.showPrevious();
            i--;
            return true;
        }
        return true;

    }
    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }
}

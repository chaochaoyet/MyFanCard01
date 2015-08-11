package com.chao.slidingdrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chao on 2015/6/17.
 */
public class MyView extends View{
    private Paint mPaint;
    private Context mContext;
    private String mString="welcome to my world";

    public MyView(Context context) {
        super(context);
        mPaint=new Paint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MyView);
        int textColor=typedArray.getColor(R.styleable.MyView_textColor,Color.RED);
        float textSize=typedArray.getDimension(R.styleable.MyView_textSize,40);

        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
        mPaint.setStyle(Paint.Style.STROKE);

        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // mPaint=new Paint();
       // mPaint.setColor(Color.BLUE);
       // mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(new Rect(10,10,300,300),mPaint);
        canvas.drawText(mString,10,120,mPaint);

    }
}

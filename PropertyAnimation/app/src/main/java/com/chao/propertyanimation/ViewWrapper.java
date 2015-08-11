package com.chao.propertyanimation;

import android.view.View;

/**
 * Created by chao on 2015/6/15.
 */
public class ViewWrapper {
    private View mTarget;
    public ViewWrapper(View target){
        mTarget=target;
    }
    public int getWidth(){
        return  mTarget.getLayoutParams().width;
    }
    public void setWidth(int width){
        mTarget.getLayoutParams().width=width;
        mTarget.requestLayout();
    }
}

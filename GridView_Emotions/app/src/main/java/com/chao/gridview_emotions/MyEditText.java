package com.chao.gridview_emotions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.jar.Attributes;

/**
 * Created by chao on 2015/6/9.
 */
public class MyEditText extends EditText {
    public MyEditText(Context context){
        super(context);
    }
    public MyEditText(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
    }
    public void insertDrawable(int id){
        SpannableString spannableString=new SpannableString("easy");
        Drawable drawable=getResources().getDrawable(id);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        ImageSpan imageSpan=new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
        spannableString.setSpan(imageSpan,0,"easy".length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        append(spannableString);
    }
}

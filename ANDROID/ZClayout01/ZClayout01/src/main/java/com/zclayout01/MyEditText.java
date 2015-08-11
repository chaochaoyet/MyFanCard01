package com.zclayout01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.EditText;



/**
 * Created by chao on 15-3-27.
 */
public class MyEditText extends EditText{
    public MyEditText(Context context){
        super(context);
    }
    public MyEditText(Context context,AttributeSet attrs){
        super(context,attrs);
    }
    public void insertDrawable(int id){
        final SpannableString ss=new SpannableString("easy");
        Drawable drawable=getResources().getDrawable(id);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        ImageSpan span=new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
        ss.setSpan(span,0,"easy".length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        append(ss);
    }
}

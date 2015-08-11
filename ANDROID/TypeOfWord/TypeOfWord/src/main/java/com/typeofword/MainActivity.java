package com.typeofword;

import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

  final int WC= ViewGroup.LayoutParams.WRAP_CONTENT;
    private TextView bold_TV,bold_italic_TV,default_TV,default_bold_TV,italic_TV,monospace_TV,sans_serif_TV,serif_TV;
    private LinearLayout mylinerlayout;
    private LinearLayout.LayoutParams linearlayoutP;
    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        mylinerlayout=new LinearLayout(this);
        mylinerlayout.setOrientation(LinearLayout.VERTICAL);
        mylinerlayout.setBackgroundResource(R.drawable.background);
        setContentView(mylinerlayout);
        linearlayoutP=new LinearLayout.LayoutParams(WC, WC);
        constructTextView();
        setTextSizeOf();
        setTextViewText();
        setTypeOfFond();
        addTextViewtoLayout();
    }
    public void constructTextView(){
        bold_TV=new TextView(this);
        bold_italic_TV=new TextView(this);
        default_TV=new TextView(this);
        default_bold_TV=new TextView(this);
        italic_TV=new TextView(this);
        monospace_TV=new TextView(this);
        sans_serif_TV=new TextView(this);
        serif_TV=new TextView(this);
    }
    public void setTextSizeOf(){
        bold_TV.setTextSize(24.0f);
        bold_italic_TV.setTextSize(24.0f);
        default_TV.setTextSize(24.0f);
        default_bold_TV.setTextSize(24.0f);
        italic_TV.setTextSize(24.0f);
        monospace_TV.setTextSize(24.0f);
        sans_serif_TV.setTextSize(24.0f);
        serif_TV.setTextSize(24.0f);
    }
    public void setTextViewText(){
        bold_TV.setText("BOLD");
        bold_italic_TV.setText("BOLD_ITALIC");
        default_TV.setText("DEFAULT");
        default_bold_TV.setText("DEFAULT_BOLD");
        italic_TV.setText("ITALIC");
        monospace_TV.setText("MONOSPACE");
        sans_serif_TV.setText("SANS_SERIF");
        serif_TV.setText("SERIF");

    }
    public void setTypeOfFond(){
        bold_TV.setTypeface(null, Typeface.BOLD);
        bold_italic_TV.setTypeface(null ,Typeface.BOLD_ITALIC);
        default_TV.setTypeface(Typeface.DEFAULT);
        default_bold_TV.setTypeface(Typeface.DEFAULT_BOLD);
        italic_TV.setTypeface(null,Typeface.ITALIC);
        monospace_TV.setTypeface(Typeface.MONOSPACE);
       sans_serif_TV.setTypeface(Typeface.SANS_SERIF);
        serif_TV.setTypeface(Typeface.SERIF);


    }
    public void addTextViewtoLayout(){
        mylinerlayout.addView(bold_TV,linearlayoutP);
        mylinerlayout.addView(bold_italic_TV,linearlayoutP);
        mylinerlayout.addView(default_TV,linearlayoutP);
        mylinerlayout.addView(default_bold_TV,linearlayoutP);
        mylinerlayout.addView(italic_TV,linearlayoutP);
        mylinerlayout.addView(monospace_TV,linearlayoutP);
        mylinerlayout.addView(sans_serif_TV,linearlayoutP);
        mylinerlayout.addView(serif_TV,linearlayoutP);
    }

    
}

package com.change_color;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.LinearLayout;

public class ColorActivity extends Activity {


    private LinearLayout myLayout;
    private LinearLayout.LayoutParams layoutP;
    private int WC=LinearLayout.LayoutParams.WRAP_CONTENT;
    private TextView black_tv,blue_tv,cyan_tv,yellow_tv,red_tv,green_tv;
    @Override
    public void onCreate(Bundle savedInterfaceState){
        super.onCreate(savedInterfaceState);
        myLayout=new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.setBackgroundResource(R.drawable.back);
        setContentView(myLayout);
        layoutP=new LinearLayout.LayoutParams(WC,WC);
        constructTextView();
        addTextView();
        setTextViewColor();
        setTextViewText();



    }
    public void setTextViewText(){
        black_tv.setText("black");
        blue_tv.setText("blue");
        cyan_tv.setText("cyan");
        yellow_tv.setText("yellow");
        red_tv.setText("red");
        green_tv.setText("green");
    }
    public void setTextViewColor(){
        black_tv.setTextColor(Color.BLACK);
        blue_tv.setTextColor(Color.BLUE);
        cyan_tv.setTextColor(Color.CYAN);
        yellow_tv.setTextColor(Color.YELLOW);
        red_tv.setTextColor(Color.RED);
        green_tv.setTextColor(Color.GREEN);
    }
    public void constructTextView(){
        black_tv=new TextView(this);
        blue_tv=new TextView(this);
        cyan_tv=new TextView(this);
        yellow_tv=new TextView(this);
        red_tv=new TextView(this);
        green_tv=new TextView(this);
    }
    public void addTextView(){
        myLayout.addView(black_tv,layoutP);
        myLayout.addView(blue_tv,layoutP);
        myLayout.addView(cyan_tv,layoutP);
        myLayout.addView(yellow_tv,layoutP);
        myLayout.addView(red_tv,layoutP);
        myLayout.addView(green_tv,layoutP);

    }



}

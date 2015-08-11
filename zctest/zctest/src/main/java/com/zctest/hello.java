package com.zctest;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by chao on 15-3-12.
 */
public class hello extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TextView textView=new TextView(this);
        textView.setText("这是一个测试程序");
        setContentView(textView);
    }
}

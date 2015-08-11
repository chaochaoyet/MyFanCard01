package com.zctset1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;


public class HelloActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TextView textView=new TextView(this);
        textView.setText("’≈≥¨");


        setContentView(textView);
    }

}



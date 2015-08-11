package com.display;

import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        String showsize="手机分辨率：\n"+displayMetrics.widthPixels+"*"+displayMetrics.heightPixels;
        TextView myshow=(TextView)findViewById(R.id.text0);
        myshow.setText(showsize);
    }



    
}

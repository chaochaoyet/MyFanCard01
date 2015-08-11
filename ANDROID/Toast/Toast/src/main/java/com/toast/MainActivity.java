package com.toast;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=new ImageView(this);
        TextView textView=new TextView(this);
        textView.setText("jiayou");


        imageView.setImageResource(R.drawable.ic_launcher);
        Toast toast=new Toast(this);
        toast.setView(imageView);
        toast.setView(textView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();





    }



    
}

package com.register;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    private Button mybutton=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton=(Button)findViewById(R.id.mybutton);
        mybutton.setOnClickListener(new Mybuttonlistener());
    }
    class Mybuttonlistener implements View.OnClickListener{
        public void onClick(View view){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,NextActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }
}





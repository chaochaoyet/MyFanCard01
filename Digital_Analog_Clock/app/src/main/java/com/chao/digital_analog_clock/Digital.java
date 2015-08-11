package com.chao.digital_analog_clock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by chao on 2015/4/3.
 */
public class Digital extends Activity{
    private Button home_button,AC_button;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digital_clock);
        home_button=(Button)findViewById(R.id.home_button);
        AC_button=(Button)findViewById(R.id.AC_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(Digital.this,MainActivity.class);
                Digital.this.startActivity(intent);
                Digital.this.finish();

            }
        });
        AC_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(Digital.this,Analog.class);
                Digital.this.startActivity(intent);
                Digital.this.finish();
            }
        });
    }
}

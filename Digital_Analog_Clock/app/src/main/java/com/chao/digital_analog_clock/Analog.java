package com.chao.digital_analog_clock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by chao on 2015/4/3.
 */
public class Analog extends Activity{
    private Button home_button,DC_button;
    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analogclock);
        home_button=(Button)findViewById(R.id.home_button_1);
        DC_button=(Button)findViewById(R.id.DC_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(Analog.this,MainActivity.class);
                Analog.this.startActivity(intent);
                Analog.this.finish();
            }
        });
        DC_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(Analog.this,Digital.class);
                Analog.this.startActivity(intent);
                Analog.this.finish();
            }
        });
    }

}

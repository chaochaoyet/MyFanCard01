package com.zcbutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZCbuttonActivity extends Activity {
    private Button mybutton;
    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zcbutton_main);
        mybutton=(Button)findViewById(R.id.showbutton);
        myText=(TextView)findViewById(R.id.showText);
        mybutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                myText.setText("按钮之后的内容");

            }
        });

    }



    
}

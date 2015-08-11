package com.click;

import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button mButton1;
    private TextView mTextView1;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 =(Button) findViewById(R.id.myButton1);
        mTextView1 = (TextView) findViewById(R.id.myTextView1);

        mButton1.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                mTextView1.setText("Hi, Everyone!!");            //按钮按下的处理部分
            }
        });
    }
}


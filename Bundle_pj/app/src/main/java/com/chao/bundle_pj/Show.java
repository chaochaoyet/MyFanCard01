package com.chao.bundle_pj;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class Show extends Activity {
    private TextView mTextView01;
    private TextView mTextView02;
    private Button mButton1;
    private String Sex;

    private String SextText,Height;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        Bundle bun=this.getIntent().getExtras();
        Sex=bun.getString("Sex");
        Height=bun.getString("Height");
        if(Sex.equals("M"))
        {
            SextText="男性";
        }
        else
        {
            SextText="女性";
        }

//取得標準體重

        mTextView01=(TextView)findViewById(R.id.text1);
        mTextView02=(TextView)findViewById(R.id.text2);
        String result = "您是一位" + SextText +
                "您的身高为：" + Height + "cm";
        String result2= "您的标准体重为：100千克";
        mTextView01.setText(result);
        mTextView02.setText(result2);

        mButton1=(Button)findViewById(R.id.button2);
        mButton1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Intent intent=new Intent();
                intent.setClass(Show.this, MainActivity.class);
                startActivity(intent);
                Show.this.finish();
            }
        });
    }




}


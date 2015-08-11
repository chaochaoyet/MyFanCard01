package com.chao.bundle_pj;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
public class MainActivity extends Activity {
    private Button mButton;
    private EditText mEditText;
    private RadioGroup mRadioGroup;

    private String Sex,height;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.button1);
        mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                mEditText=(EditText)findViewById(R.id.edit);

                mRadioGroup=(RadioGroup)findViewById(R.id.RG);
                height=mEditText.getText().toString();
                if(mRadioGroup.getCheckedRadioButtonId()==R.id.RB1)
                {
                    Sex="M";
                }
                else
                {
                    Sex="F";
                }
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, Show.class);
                Bundle bun=new Bundle();
                bun.putString("Height", height);
                bun.putString("Sex", Sex);
                intent.putExtras(bun);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }
}
package com.chao.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener{
    private CheckBox cb1,cb2,cb3,cb4;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);
        textView=(TextView)findViewById(R.id.textview);
        button=(Button)findViewById(R.id.button);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str="";
                if(cb1.isChecked())
                    str=str+cb1.getText();
                if(cb2.isChecked())
                    str=str+cb2.getText();
                if(cb3.isChecked())
                    str=str+cb3.getText();
                if (cb4.isChecked())
                    str=str+cb4.getText();
                Toast.makeText(MainActivity.this,str+"is choosed",Toast.LENGTH_LONG).show();
            }
        });



    }









    @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            Toast.makeText(MainActivity.this,compoundButton.getText()+"is choosed",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,compoundButton.getText()+"is not choosed",Toast.LENGTH_LONG).show();
        }
    }
}

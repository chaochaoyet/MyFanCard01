package com.chao.computer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    private Button button01,button02,button03,button04;
    private TextView textView01,textView02;
    private EditText editText01,editText02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button01=(Button)findViewById(R.id.button01);
        button02=(Button)findViewById(R.id.button02);
        button03=(Button)findViewById(R.id.button03);
        button04=(Button)findViewById(R.id.button04);
        editText01=(EditText)findViewById(R.id.edit01);
        editText02=(EditText)findViewById(R.id.edit02);
        textView01=(TextView)findViewById(R.id.text01);
        textView02=(TextView)findViewById(R.id.text02);
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);




    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button01:
                if(editText01.getText().toString().equals("")||editText02.getText().toString().equals(""))
                    break;
                textView01.setText("+");
                textView02.setText(Float.toString((Float.parseFloat(editText01.getText().toString())+
                        (Float.parseFloat(editText02.getText().toString())))));
                break;
            case R.id.button02:
                if(editText01.getText().toString().equals("")||editText02.getText().toString().equals(""))
                    break;
                textView01.setText("-");
                textView02.setText(Float.toString((Float.parseFloat(editText01.getText().toString())-
                        (Float.parseFloat(editText02.getText().toString())))));
                break;
            case R.id.button03:
                if(editText01.getText().toString().equals("")||editText02.getText().toString().equals(""))
                    break;
                textView01.setText("*");
                textView02.setText(Float.toString((Float.parseFloat(editText01.getText().toString())*
                        (Float.parseFloat(editText02.getText().toString())))));

                break;
            case R.id.button04:
                if(editText01.getText().toString().equals("")||editText02.getText().toString().equals(""))
                    break;
                textView01.setText("/");
                textView02.setText(Float.toString((Float.parseFloat(editText01.getText().toString())/
                        (Float.parseFloat(editText02.getText().toString())))));
                break;
            default:
                break;

        }
    }







}

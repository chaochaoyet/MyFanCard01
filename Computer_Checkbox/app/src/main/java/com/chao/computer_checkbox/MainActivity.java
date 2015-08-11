package com.chao.computer_checkbox;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener{
    private EditText editText1,editText2;
    private TextView textView11,textView12,textView13,textView14,textView15,
    textView21,textView22,textView23,textView24,textView25,
    textView31,textView32,textView33,textView34,textView35,
    textView41,textView42,textView43,textView44,textView45;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1=(CheckBox)findViewById(R.id.CB1);
        checkBox2=(CheckBox)findViewById(R.id.CB2);
        checkBox3=(CheckBox)findViewById(R.id.CB3);
        checkBox4=(CheckBox)findViewById(R.id.CB4);
        textView11=(TextView)findViewById(R.id.text11);
        textView12=(TextView)findViewById(R.id.text12);
        textView13=(TextView)findViewById(R.id.text13);
        textView14=(TextView)findViewById(R.id.text14);
        textView15=(TextView)findViewById(R.id.text15);
        textView21=(TextView)findViewById(R.id.text21);
        textView22=(TextView)findViewById(R.id.text22);
        textView23=(TextView)findViewById(R.id.text23);
        textView24=(TextView)findViewById(R.id.text24);
        textView25=(TextView)findViewById(R.id.text25);
        textView31=(TextView)findViewById(R.id.text31);
        textView32=(TextView)findViewById(R.id.text32);
        textView33=(TextView)findViewById(R.id.text33);
        textView34=(TextView)findViewById(R.id.text34);
        textView35=(TextView)findViewById(R.id.text35);
        textView41=(TextView)findViewById(R.id.text41);
        textView42=(TextView)findViewById(R.id.text42);
        textView43=(TextView)findViewById(R.id.text43);
        textView44=(TextView)findViewById(R.id.text44);
        textView45=(TextView)findViewById(R.id.text45);

        editText1=(EditText)findViewById(R.id.edit_firstnumber);
        editText2=(EditText)findViewById(R.id.edit_secondnumber);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(checkBox1.isChecked()){
            if(editText1.getText().toString().equals("")||editText2.getText().toString().equals(""))
                return;
            else {
                textView11.setText(editText1.getText().toString());
                textView12.setText("+");
                textView13.setText(editText2.getText().toString());
                textView14.setText("=");
                textView15.setText(Float.toString(Float.parseFloat(editText1.getText().toString())+Float.parseFloat(editText2.getText().toString())));
            }

        }
        if(checkBox2.isChecked()){
            if(editText1.getText().toString().equals("")||editText2.getText().toString().equals(""))
                return;
            else {
                textView21.setText(editText1.getText().toString());
                textView22.setText("-");
                textView23.setText(editText2.getText().toString());
                textView24.setText("=");
                textView25.setText(Float.toString(Float.parseFloat(editText1.getText().toString())-Float.parseFloat(editText2.getText().toString())));
        }
    }
        if(checkBox3.isChecked()){
            if(editText1.getText().toString().equals("")||editText2.getText().toString().equals(""))
                return;
            else {
                textView31.setText(editText1.getText().toString());
                textView32.setText("*");
                textView33.setText(editText2.getText().toString());
                textView34.setText("=");
                textView35.setText(Float.toString(Float.parseFloat(editText1.getText().toString())*Float.parseFloat(editText2.getText().toString())));
            }
        }
        if(checkBox4.isChecked()){
            if(editText1.getText().toString().equals("")||editText2.getText().toString().equals(""))
                return;
            else {
                textView41.setText(editText1.getText().toString());
                textView42.setText("/");
                textView43.setText(editText2.getText().toString());
                textView44.setText("=");
                textView45.setText(Float.toString(Float.parseFloat(editText1.getText().toString())/Float.parseFloat(editText2.getText().toString())));
            }
        }
}}

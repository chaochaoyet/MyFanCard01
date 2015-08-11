package com.chao.typeface;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);
        radioButton1=(RadioButton)findViewById(R.id.radiobutton1);
        radioButton2=(RadioButton)findViewById(R.id.radiobutton2);
        radioButton3=(RadioButton)findViewById(R.id.radiobutton3);
        radioButton4=(RadioButton)findViewById(R.id.radiobutton4);
        radioButton5=(RadioButton)findViewById(R.id.radiobutton5);
        editText=(EditText)findViewById(R.id.editview);
        textView=(TextView)findViewById(R.id.textview);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==radioButton1.getId()&&radioButton1.isChecked()){
                    textView.setText(editText.getText());
                    textView.setTextColor(Color.BLUE);
                    textView.setTypeface(Typeface.DEFAULT,Typeface.NORMAL);
                }
                else if(i==radioButton2.getId()&&radioButton2.isChecked()){
                    textView.setText(editText.getText());
                    textView.setTextColor(Color.GREEN);
                    textView.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);
                }
                else if(i==radioButton3.getId()&&radioButton3.isChecked()){
                    textView.setText(editText.getText());
                    textView.setTextColor(Color.RED);
                    textView.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
                }
                else if(i==radioButton4.getId()&&radioButton4.isChecked()){
                    textView.setText(editText.getText());
                    textView.setTextColor(Color.CYAN);
                    textView.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
                }
                else if(i==radioButton5.getId()&&radioButton5.isChecked()){
                    textView.setText(editText.getText());
                    textView.setTextColor(Color.YELLOW);
                    textView.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);
                }
            }
        });

    }



}

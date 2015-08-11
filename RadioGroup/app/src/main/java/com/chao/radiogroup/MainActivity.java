package com.chao.radiogroup;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2,radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textview);
        radioGroup=(RadioGroup)findViewById(R.id.RG);
        radioButton1=(RadioButton)findViewById(R.id.RB1);
        radioButton2=(RadioButton)findViewById(R.id.RB2);
        radioButton3=(RadioButton)findViewById(R.id.RB3);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==radioButton1.getId()&&radioButton1.isChecked()){
                    textView.setText(radioButton1.getText());
                }
                else if(i==radioButton2.getId()&&radioButton2.isChecked()){
                    textView.setText(radioButton2.getText());
                }
                else if (i==radioButton3.getId()&&radioButton3.isChecked()){
                    textView.setText(radioButton3.getText());
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

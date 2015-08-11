package com.edit_text;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editText=(EditText)findViewById(R.id.edit1);
         textView=(TextView)findViewById((R.id.text2));
        textView.setText("œ‘ æ±‡º≠µƒƒ⁄»›");
        editText.setOnKeyListener(new EditText.OnKeyListener(){
            @Override
            public boolean onKey(View view,int keyCode,KeyEvent event){
                textView.setText(editText.getText());
                return false;
            }
        });
    }



    
}

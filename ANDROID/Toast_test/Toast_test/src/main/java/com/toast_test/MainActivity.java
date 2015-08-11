package com.toast_test;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button button;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.edit_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable str;
                str=editText.getText();
                CharSequence string_1=getString(R.string.yourwish);
                CharSequence string_2=getString(R.string.hassend);
                Toast.makeText(MainActivity.this,string_1+str.toString()+string_2,Toast.LENGTH_LONG).show();
                editText.setText("over");
            }
        });
    }



    
}

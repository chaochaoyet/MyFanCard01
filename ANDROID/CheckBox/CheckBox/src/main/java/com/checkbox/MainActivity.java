package com.checkbox;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView showadvice,yourchoice;
    private CheckBox iaccept;
    private Button ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showadvice=(TextView)findViewById(R.id.TextView_Guide);
        yourchoice=(TextView)findViewById(R.id.TextView_yourChoice);
        iaccept=(CheckBox)findViewById(R.id.checkbox_accept);
        ok=(Button)findViewById(R.id.Button_ok);
        CharSequence titleString=getString(R.string.allOk);
        iaccept.setHint(titleString);
        iaccept.setHintTextColor(Color.RED);
        iaccept.setChecked(false);
        ok.setEnabled(false);
        iaccept.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iaccept.isChecked()){
                    ok.setEnabled(true);
                    yourchoice.setText(R.string.accept);
                }
                else {
                    ok.setEnabled(false);
                    yourchoice.setText(R.string.Notaccept);
                }
            }
        });
        ok.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iaccept.isChecked()){
                    showadvice.setText(R.string.accept);
                }
            }
        });
    }



    
}

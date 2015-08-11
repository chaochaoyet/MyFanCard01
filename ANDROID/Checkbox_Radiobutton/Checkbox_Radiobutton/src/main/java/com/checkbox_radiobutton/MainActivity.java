package com.checkbox_radiobutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;

public class MainActivity extends Activity {
    private RadioButton button_on;
    private CheckBox checkBox;
    private ImageView imageView1,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_on=(RadioButton)findViewById(R.id.on);
        checkBox=(CheckBox)findViewById(R.id.checkbox);
        imageView1=(ImageView)findViewById(R.id.imageview1);
        imageView2=(ImageView)findViewById(R.id.imageview2);

        button_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imageView1.setImageResource(b?R.drawable.photo1:R.drawable.photo2);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imageView2.setImageResource(b?R.drawable.photo1:R.drawable.photo2);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

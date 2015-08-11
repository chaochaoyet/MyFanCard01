package com.standardweight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by chao on 15-3-19.
 */
public class WeightActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        Button button=(Button)findViewById(R.id.compute_button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText=(EditText)findViewById(R.id.height_edit);
                double height=Double.parseDouble(editText.getText().toString());
                String sex;
                RadioButton radioButton1=(RadioButton)findViewById(R.id.sex_man);
                if(radioButton1.isChecked()){
                    sex="man";

                }
                else
                    sex="woman";
                Intent intent=new Intent();
                intent.setClass(WeightActivity.this,ShowActivity.class);
                Bundle bundle=new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}

package com.example.mmm;


import android.app.Activity;
import android.content.Intent;
import android.view.View;//注意view的大小写
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
public class NextActivity extends Activity{
    private Button my_button2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        my_button2 = (Button)findViewById(R.id.my_button2);
        my_button2.setText("Last");
        my_button2.setOnClickListener(new MyButtonListener1());
    }
    class MyButtonListener1 implements OnClickListener{
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(NextActivity.this,MainActivity.class);
            NextActivity.this.startActivity(intent);
        }
    }


}

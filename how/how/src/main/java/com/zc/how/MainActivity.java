package com.zc.how;

import android.app.Activity;
import android.content.Intent;
import android.view.View;//注意view的大小写
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button my_button=null;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_button=(Button)findViewById( R.id.my_button);
        my_button.setText( "下一个" );
        my_button.setOnClickListener(new MyButtonListener());
    }
   class MyButtonListener implements OnClickListener{
       public void onClick(View view){
           Intent intent=new Intent();
           intent.setClass(MainActivity.this,NextActivity.class);
           MainActivity.this.startActivity(intent);
       }
   }
}

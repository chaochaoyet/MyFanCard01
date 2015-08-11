package com.chao.intent_bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by chao on 2015/4/8.
 */
public class Second extends Activity{
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        button=(Button)findViewById(R.id.second_button);
        textView=(TextView)findViewById(R.id.textview);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        String str=bundle.getString("this is a test");
        textView.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Second.this,MainActivity.class);
                Bundle bundle1=new Bundle();
                bundle1.putString("last",(String)button.getText());
                intent1.putExtras(bundle1);
                Second.this.startActivity(intent1);
            }
        });
    }
}

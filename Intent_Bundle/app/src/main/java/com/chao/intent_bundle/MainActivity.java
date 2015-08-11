package com.chao.intent_bundle;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.first_button);
        textView=(TextView)findViewById(R.id.textview1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Second.class);
                Bundle bundle=new Bundle();
                bundle.putString("this is a test",(String)button.getText());
                intent.putExtras(bundle);
                MainActivity.this.startActivity(intent);
            }
        });

    }



}

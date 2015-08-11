package com.chao.adjustment;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private TextView textView;
    private Button land_button,port_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        land_button=(Button)findViewById(R.id.land_button);
        port_button=(Button)findViewById(R.id.port_button);
        textView=(TextView)findViewById(R.id.text);
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==land_button){
                    MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                else {MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);}
            }
        };
        land_button.setOnClickListener(onClickListener);
        port_button.setOnClickListener(onClickListener);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(this.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
           textView.setText(textView.getText().toString()+"land");
        }
        else {
           textView.setText(textView.getText().toString()+"port");
        }
    }
}

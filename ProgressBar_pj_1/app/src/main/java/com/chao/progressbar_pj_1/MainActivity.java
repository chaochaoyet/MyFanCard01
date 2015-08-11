package com.chao.progressbar_pj_1;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {
    private Button start_button, stop_button;
    private Handler handler = new Handler();
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_button = (Button) findViewById(R.id.start_button);
        stop_button = (Button) findViewById(R.id.stop_button);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        progressBar.setProgress(0);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(runnable);
                progressBar.setVisibility(View.VISIBLE);


            }
        });
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                progressBar.setProgress(0);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
           if(progressBar.getProgress()<100){
               progressBar.setProgress(progressBar.getProgress()+10);
               handler.postDelayed(runnable, 3000);
           }
           else
               progressBar.setVisibility(View.INVISIBLE);
        }
    };
}


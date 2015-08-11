package com.progressbar;

import android.os.Bundle;
import android.app.Activity;

import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;




public class MainActivity extends Activity {
    private Button start,stop;
    private ProgressBar progressBar;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        progressBar.setProgress(0);
        start.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(runnable);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                progressBar.setProgress(0);

            }
        });

    }
    int pro=0;
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            progressBar.setVisibility(View.VISIBLE);
            pro=progressBar.getProgress()+10;
            progressBar.setProgress(pro);
            if(pro<100){
                handler.postDelayed(runnable,1000);
            }
            else {
                progressBar.setVisibility(View.GONE);
                handler.removeCallbacks(runnable);
                progressBar.setProgress(0);

            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}



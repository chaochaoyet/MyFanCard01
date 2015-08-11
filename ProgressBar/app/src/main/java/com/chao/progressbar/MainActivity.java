package com.chao.progressbar;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.logging.LogRecord;


public class MainActivity extends Activity {
    private TextView tv;
    private Button start,stop;
    private ProgressBar progressBar;
   private Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);
        tv=(TextView)findViewById(R.id.textview);
        progressBar=(ProgressBar)findViewById(R.id.PB);
        progressBar.setProgress(0);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("is starting the progress...");
                handler.post(runnable);

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("is stopping the progress...");
                handler.removeCallbacks(runnable);
                progressBar.setProgress(0);
            }
        });
    }
    int i=0;
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            progressBar.setVisibility(View.VISIBLE);
            i=progressBar.getProgress()+10;
            progressBar.setProgress(i);
            if(i<100){
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

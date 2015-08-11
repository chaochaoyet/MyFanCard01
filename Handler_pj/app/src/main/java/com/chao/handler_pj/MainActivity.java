package com.chao.handler_pj;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;




public class MainActivity extends ActionBarActivity {
    private Button button1,button2;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.start_button);
        button2=(Button)findViewById(R.id.stop_button);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                handler.post(runnable);

            }
        });


    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handler.post(runnable);
        }
    };
    int i=0;
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Message msg=new Message();
            msg.arg1=i;
            progressBar.setProgress(msg.arg1);
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                e.toString();
            }
            handler.sendMessage(msg);
            i=i+10;

            if(msg.arg1>100){
                handler.removeCallbacks(runnable);
                progressBar.setVisibility(View.INVISIBLE);
            }



        }
    };



}

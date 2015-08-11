package com.chao.progressbar_pj;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {
    private ProgressBar progressBar_1,progressBar_2;
    private Button button;
    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar_1=(ProgressBar)findViewById(R.id.progressbar_first);
        progressBar_2=(ProgressBar)findViewById(R.id.progressbar_second);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    progressBar_1.setVisibility(View.VISIBLE);

                    progressBar_2.setVisibility(View.VISIBLE);

                }
                else if(i<100){
                    progressBar_1.setProgress(i);
                    progressBar_1.setSecondaryProgress(i+10);
                }
                else {
                    progressBar_1.setVisibility(View.GONE);
                    progressBar_2.setVisibility(View.GONE);
                }
                i=i+10;




            }
        });
    }



}

package com.chao.videoplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends ActionBarActivity {
    private Button sd,vv;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sd=(Button)findViewById(R.id.sd);
        vv=(Button)findViewById(R.id.vv);
        videoView=(VideoView)findViewById(R.id.video);
        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Video/zctest.MOV");
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.setVideoURI(uri);
                videoView.start();
                videoView.requestFocus();
            }
        });
        sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Video/zctest.MOV");
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(uri,"video/mp4");
                startActivity(intent);
            }
        });
    }


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

package com.chao.mediaplayertest;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.net.URI;
import java.net.URL;


public class MainActivity extends ActionBarActivity {
    private Button res,sd,uri;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res=(Button)findViewById(R.id.res);
        sd=(Button)findViewById(R.id.sd);
        uri=(Button)findViewById(R.id.uri);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=MediaPlayer.create(MainActivity.this,R.raw.test);
                player.start();

            }
        });
        sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=new MediaPlayer();
                String path="Music/test.mp3";
                File audioFile=new File(Environment.getExternalStorageDirectory(),path);
                try{
                    player.reset();
                    player.setDataSource(audioFile.getAbsolutePath());
                    player.prepare();
                    player.start();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        uri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=new MediaPlayer();
                try{
                    player.setDataSource("http://www.mobvcasting.com/android/audio/goodmorningandroid.mp3");
                    player.prepare();
                    player.start();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }



}

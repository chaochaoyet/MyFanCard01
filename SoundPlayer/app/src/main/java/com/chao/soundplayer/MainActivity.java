package com.chao.soundplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {
    private Button button,bg;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg=(Button)findViewById(R.id.bg);
        final MediaPlayer mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource("内存设备/Music/test.mp3");//设置路径
            mediaPlayer.prepare();//缓冲
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioManager audioManager=(AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });





        soundPool=new SoundPool(10, AudioManager.STREAM_SYSTEM,5);
        final int soundid=soundPool.load(this,R.raw.buzzer,0);
       button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(soundid,1,1,0,-1,1);
            }
        });
    }



}

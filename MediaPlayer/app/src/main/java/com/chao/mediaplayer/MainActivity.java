package com.chao.mediaplayer;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private static final String TAG = "AudioPlayerActivity";
    private EditText filenameText;
    private MediaPlayer mediaPlayer;
    private String filename;
    private int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filenameText = (EditText)this.findViewById(R.id.filename);

        mediaPlayer = new MediaPlayer();

        ButtonClickListener listener = new ButtonClickListener();
        Button playButton = (Button)this.findViewById(R.id.play);
        Button pauseButton = (Button)this.findViewById(R.id.pause);
        Button resetButton = (Button)this.findViewById(R.id.reset);
        Button stopButton = (Button) this.findViewById(R.id.stop);
        playButton.setOnClickListener(listener);
        pauseButton.setOnClickListener(listener);
        resetButton.setOnClickListener(listener);
        stopButton.setOnClickListener(listener);
        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        this.filename = savedInstanceState.getString("filename");
        this.position = savedInstanceState.getInt("position");
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("filename", filename);
        outState.putInt("position", position);
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onPause() {//如果突然电话到来，停止播放音乐
        if(mediaPlayer.isPlaying()){
            position = mediaPlayer.getCurrentPosition();//保存当前播放点
            mediaPlayer.stop();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        if(position>0 && filename!=null){//如果电话结束，继续播放音乐
            try {
                play();
                mediaPlayer.seekTo(position);
                position = 0;
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            }
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    private final class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            filename = filenameText.getText().toString();//先得到文本框中的内容
            Button button = (Button) v;//得到button
            try {
                switch (v.getId()) {//通过传过来的Buttonid可以判断Button的类型
                    case R.id.play://播放
                        play();
                        break;

                    case R.id.pause:
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.pause();
                            button.setText(R.string.continue1);//让这个按钮上的文字显示为继续
                        }else{
                            mediaPlayer.start();//继续播放
                            button.setText(R.string.pause);
                        }
                        break;

                    case R.id.reset:
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.seekTo(0);//让它从0开始播放
                        }else{
                            play();//如果它没有播放，就让它开始播放
                        }
                        break;

                    case R.id.stop:
                        if(mediaPlayer.isPlaying()) mediaPlayer.stop();//如果它正在播放的话，就让他停止
                        break;
                }
            } catch (Exception e) {//抛出异常
                Log.e(TAG, e.toString());
            }
        }
    }
    private void play() throws IOException {
        File audioFile = new File(Environment.getExternalStorageDirectory(),filename);
        mediaPlayer.reset();
        mediaPlayer.setDataSource(audioFile.getAbsolutePath());
        mediaPlayer.prepare();
        mediaPlayer.start();//播放
    }
}

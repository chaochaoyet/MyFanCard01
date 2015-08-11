package com.chao.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private SharedPreferences sharedPreferences;
    private Button add_button,sub_button,mute_button;
    private static int cur_voice=0;
    private static final int MIN_VOICE=0,MAX_VOICE=8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("preference", Context.MODE_PRIVATE);
        add_button=(Button)findViewById(R.id.add_button);
        sub_button=(Button)findViewById(R.id.sub_button);
        mute_button=(Button)findViewById(R.id.mute_button);
        cur_voice=getVoicevalue(sharedPreferences);
        Toast.makeText(MainActivity.this,"上次设置音量:"+cur_voice,Toast.LENGTH_SHORT).show();
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cur_voice<MAX_VOICE)
                    cur_voice=cur_voice+1;
                String voicetext=(String)generateVoice(cur_voice);
                Toast.makeText(MainActivity.this,"音量"+cur_voice+"\n"+voicetext,Toast.LENGTH_SHORT).show();
                saveVoicevalue(cur_voice,sharedPreferences);
            }
        });
        sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cur_voice>MIN_VOICE)
                    cur_voice=cur_voice-1;
                String voicetext=(String)generateVoice(cur_voice);
                Toast.makeText(MainActivity.this,"音量"+cur_voice+"\n"+voicetext,Toast.LENGTH_SHORT).show();
                saveVoicevalue(cur_voice,sharedPreferences);
            }
        });
        mute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur_voice=0;
                String voicetext=(String)generateVoice(cur_voice);
                Toast.makeText(MainActivity.this,"音量"+cur_voice+"\n"+voicetext,Toast.LENGTH_SHORT).show();
                saveVoicevalue(cur_voice,sharedPreferences);
            }
        });
    }
    private CharSequence generateVoice(int voice){
        CharSequence str="";
        while (voice>0){
            str=str+"|";
            voice--;
        }
        return str;
    }
    private void saveVoicevalue(int voicevalue,SharedPreferences sharedPreferences){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("key",voicevalue);
        boolean ret=editor.commit();
        if(ret=true){
            Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(MainActivity.this,"保存失败",Toast.LENGTH_SHORT).show();
    }
    private int getVoicevalue(SharedPreferences sharedPreferences){
        int ret=sharedPreferences.getInt("key",0);
        return ret;
    }




}

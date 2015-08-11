package com.chao.preferencedemo;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        int counter=mPreferences.getInt("counter",1);
        textView=(TextView)findViewById(R.id.text);
        textView.setText("This app has been started "+counter+" times");
        SharedPreferences.Editor mEditor=mPreferences.edit();
        mEditor.putInt("counter",++counter);
        mEditor.commit();
    }



}

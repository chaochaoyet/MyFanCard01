package com.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String[] cities={"北京市","上海市","成都市","天津市","重庆市"};
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView=(TextView)findViewById(R.id.texteview_show);
        mySpinner=(Spinner)findViewById(R.id.spinner_city);
        myAnimation= AnimationUtils.loadAnimation(this,R.anim.my_anim);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cities);
        adapter.setDropDownViewResource(R.layout.my_spinner);
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                myTextView.setText("你选择的是:"+cities[i]);
                adapterView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                myTextView.setText("NONE");

            }
        });
        mySpinner.setOnTouchListener(   new Spinner.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.startAnimation(myAnimation);
                view.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });
    }



    
}

package com.btton_layout;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{
    private FragmentTabHost fragmentTabHost;
    private String texts[]={"首页","消息","好友","广场","更多"};
    private int imageButton[]={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
    private Class fragmentArray[]={FragmentPage1.class,FragmentPage2.class,FragmentPage3.class,FragmentPage4.class,FragmentPage5.class};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentTabHost=(FragmentTabHost)findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.maincontent);

        for (int i=0;i<texts.length;i++){
            TabSpec spec=fragmentTabHost.newTabSpec(texts[i]).setIndicator(getView(i));
            fragmentTabHost.addTab(spec, fragmentArray[i], null);
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.ic_launcher);
        }
    }
    private View getView(int i){
        View view=View.inflate(MainActivity.this, R.layout.tabcontent, null);
        ImageView imageView=(ImageView) view.findViewById(R.id.image);
        TextView textView=(TextView) view.findViewById(R.id.text);
        imageView.setImageResource(imageButton[i]);
        textView.setText(texts[i]);
        return view;

    }

}
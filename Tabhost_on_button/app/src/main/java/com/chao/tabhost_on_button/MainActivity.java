package com.chao.tabhost_on_button;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("主页",getResources().getDrawable(R.drawable.photo1)).setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("消息",getResources().getDrawable(R.drawable.photo2)).setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("搜索",getResources().getDrawable(R.drawable.photo3)).setContent(R.id.view3));
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("我",getResources().getDrawable(R.drawable.photo4)).setContent(R.id.view4));
        tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("更多",getResources().getDrawable(R.drawable.photo5)).setContent(R.id.view5));
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

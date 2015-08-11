package com.chao.load_weibo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;


public class MainActivity extends ActionBarActivity {
    private Button refresh,edit;
    private TextView user;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refresh=(Button)findViewById(R.id.refresh);
        edit=(Button)findViewById(R.id.edit);
        listView=(ListView)findViewById(R.id.home_lv);
        user=(TextView)findViewById(R.id.user);
        refresh.setOnClickListener(new MyClick());
        edit.setOnClickListener(new MyClick());

    }
    class  MyClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.refresh:

                    break;
                case R.id.edit:
                    break;

            }
        }
    }



}

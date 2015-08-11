package com.chao.intent_pj;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.net.URI;


public class MainActivity extends ActionBarActivity {
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("smsto://1008611");
                Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("zc","Hello");
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri1=Uri.parse("tel:1234450965");
                Intent intent1=new Intent(Intent.ACTION_CALL,uri1);
                startActivity(intent1);
            }
        });
    }



}

package com.chao.mars_json;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private static final String jsonData="[{\"name\":\"Michale\",\"age\":20},{\"name\":\"Jack\",\"age\":30}]";
    private static final String jsonData_1="{\"name\":\"Mike\",\"age\":20}";
    private Button button,button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonUtils jsonUtils=new JsonUtils();
                jsonUtils.parseJsonArray(jsonData);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonUtils_1 jsonUtils_1=new JsonUtils_1();
                jsonUtils_1.parseUserFromJson(jsonData_1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonUtils_2 jsonUtils_2=new JsonUtils_2();
                jsonUtils_2.parseUsersFromJsonArray(jsonData);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonUtils_3 jsonUtils_3=new JsonUtils_3();
                jsonUtils_3.parseJson(jsonData_1);
            }
        });
    }



}

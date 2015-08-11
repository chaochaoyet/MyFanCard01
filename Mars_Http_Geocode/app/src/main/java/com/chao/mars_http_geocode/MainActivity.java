package com.chao.mars_http_geocode;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {
    private Button button;
    private static final String url="http://192.168.3.15:8080/MP3/address.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpClient httpClient=new DefaultHttpClient();
                String responseData="";
                String line="";
                try {
                    HttpResponse response=httpClient.execute(new HttpGet(url));
                    HttpEntity entity=response.getEntity();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(entity.getContent()));

                    while ((line=bufferedReader.readLine())!=null){
                        responseData=responseData+line;
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                Gson gson=new Gson();
                Location location=gson.fromJson(responseData,Location.class);
                System.out.println("Location-->" + location);


            }
        });

    }



}

package com.chao.rankinfodemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    private Thread newThread;
    private String baseURL = "http://ec2-52-27-33-107.us-west-2.compute.amazonaws.com/phpfancard/API/index.php?command=rank_list_total";
    private Button rank_btn;
    private UserData userData;
    private String user_name;
    private int user_number;
    private UserList userList;
    private ListView rank_list;
    private TextView rank_number,rank_name,rank_grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rank_btn=(Button)findViewById(R.id.rank_btn);
        rank_name=(TextView)findViewById(R.id.rank_name);
        rank_grade=(TextView)findViewById(R.id.rank_grade);
        rank_number=(TextView)findViewById(R.id.rank_number);
        rank_list=(ListView)findViewById(R.id.rank_list);
        rank_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpUtils httpUtils=new HttpUtils();
                httpUtils.send(HttpRequest.HttpMethod.GET,baseURL,new RequestCallBack<Object>() {
                    @Override
                    public void onSuccess(ResponseInfo<Object> objectResponseInfo) {
                        userList=UserList.parse(objectResponseInfo.result.toString());
                        ArrayList<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
                        HashMap<String,Object> hashMapzc=new HashMap<String, Object>();
                        hashMapzc.put("user_number","rank");
                        hashMapzc.put("user_name","name");
                        hashMapzc.put("user_grade","score");
                        list.add(hashMapzc);
                        for(int i=0;i<userList.userArrayList.size();i++){
                            HashMap<String,Object> hashMap=new HashMap<>();
                            hashMap.put("user_number",i);
                            hashMap.put("user_name",userList.userArrayList.get(i).user_name);
                            hashMap.put("user_grade",userList.userArrayList.get(i).user_points_total);
                            list.add(hashMap);

                        }
                        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,list,R.layout.list_item,new String[]{"user_number",
                                "user_name","user_grade"}, new int[]{R.id.rank_number,R.id.rank_name,R.id.rank_grade});
                        rank_list.setAdapter(simpleAdapter);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        Toast.makeText(MainActivity.this,"network error",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });





    }




}

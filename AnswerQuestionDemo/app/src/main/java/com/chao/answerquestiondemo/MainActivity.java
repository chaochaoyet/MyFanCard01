package com.chao.answerquestiondemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {
    private String basrUrl="http://ec2-52-27-33-107.us-west-2.compute.amazonaws.com/phpfancard/API/index.php?command=get_friend_quiz";
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpUtils httpUtils=new HttpUtils();
                httpUtils.send(HttpRequest.HttpMethod.GET,basrUrl,new RequestCallBack<Object>() {
                    @Override
                    public void onSuccess(ResponseInfo<Object> objectResponseInfo) {
                        try {
                            System.out.println(objectResponseInfo.result.toString());
                            JSONObject jsonObject=new JSONObject(objectResponseInfo.result.toString()).getJSONObject("data");
                            JSONArray jsonArray=jsonObject.getJSONArray("English");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=(JSONObject)jsonArray.opt(i);
                                System.out.println("www-->"+jsonObject1.getString("title"));
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        System.out.println("my result-->error");
                    }
                });

            }
        });

    }



}

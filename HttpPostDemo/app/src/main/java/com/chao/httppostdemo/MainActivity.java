package com.chao.httppostdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity
{
    private String TAG = "http";
    private EditText uid = null;



    private Button postButton = null;

    private TextView mResult = null;

    // 基本地址：服务器ip地址：端口号/Web项目逻辑地址+目标页面（Servlet）的url-pattern
    private String baseURL = "http://ec2-52-27-33-107.us-west-2.compute.amazonaws.com/phpfancard/API/index.php";
    private Thread newThread;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        uid = (EditText) findViewById(R.id.uid);

        mResult = (TextView) findViewById(R.id.result);


        postButton = (Button) findViewById(R.id.post);
        newThread=new Thread(new Runnable() {
            @Override
            public void run() {
                NameValuePair pair1 = new BasicNameValuePair("command","third_platform");
                NameValuePair pair2 = new BasicNameValuePair("platform","2");
                NameValuePair pair3 = new BasicNameValuePair("token",R.string.twitter+"");


                List<NameValuePair> pairList = new ArrayList<NameValuePair>();
                pairList.add(pair1);
                pairList.add(pair2);
                pairList.add(pair3);


                try
                {
                    HttpEntity requestHttpEntity = new UrlEncodedFormEntity(
                            pairList, HTTP.UTF_8);
                    // URL使用基本URL即可，其中不需要加参数
                    HttpPost httpPost = new HttpPost(baseURL);
                    // 将请求体内容加入请求中
                    httpPost.setEntity(requestHttpEntity);
                    // 需要客户端对象来发送请求
                    HttpClient httpClient = new DefaultHttpClient();
                    // 发送请求
                    HttpResponse response = httpClient.execute(httpPost);
                    // 显示响应
                    showResponseResult(response);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        postButton.setOnClickListener(mPostClickListener);
    }



    private OnClickListener mPostClickListener = new View.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
           newThread.start();




        }
    };

    /**
     * 显示响应结果到命令行和TextView
     * @param response
     */
    private void showResponseResult(HttpResponse response)
    {
        if (null == response)
        {
            return;
        }

        HttpEntity httpEntity = response.getEntity();
        try
        {
            InputStream inputStream = httpEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            String result = "";
            String line = "";
            while (null != (line = reader.readLine()))
            {
                result += line;

            }

            System.out.println(result);
            mResult.setText("Response Content from server: " + result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}

package com.chao.weibocode_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.UIUtils;

import java.text.SimpleDateFormat;


public class MainActivity extends Activity {
    private Button button,button1;
    private static final String TAG = "MainActivity";

    /**
     * WeiboSDKDemo 程序的 APP_SECRET。
     * 请注意：请务必妥善保管好自己的 APP_SECRET，不要直接暴露在程序中，此处仅作为一个DEMO来演示。
     */
    private static final String WEIBO_DEMO_APP_SECRET = "4cecc4bd2a7488e999fbb1a06ca04637";

    /** 通过 code 获取 Token 的 URL */
    private static final String OAUTH2_ACCESS_TOKEN_URL = "https://open.weibo.cn/oauth2/access_token";
    private static final String WEIBO_DEMO_APP_KEY = "1141626586";
    public static final String REDIRECT_URL ="https://api.weibo.com/oauth2/default.html";
    public static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";
    private AuthInfo mAuthInfo;
    private String mCode;
    private Oauth2AccessToken mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuthInfo=new AuthInfo(this,WEIBO_DEMO_APP_KEY,REDIRECT_URL,SCOPE);

        button=(Button)findViewById(R.id.ok);
        button1=(Button)findViewById(R.id.code);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WBAuthActivity.class);
                startActivity(intent);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    class AuthListener implements WeiboAuthListener {

        @Override
        public void onComplete(Bundle values) {
            if (null == values) {
                Toast.makeText(MainActivity.this,
                        "失败", Toast.LENGTH_SHORT).show();
                return;
            }

            String code = values.getString("code");
            if (TextUtils.isEmpty(code)) {
                Toast.makeText(MainActivity.this,
                       "失败", Toast.LENGTH_SHORT).show();
                return;
            }


        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this,
                    "失败", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onWeiboException(WeiboException e) {
            UIUtils.showToast(MainActivity.this,
                    "Auth exception : " + e.getMessage(), Toast.LENGTH_LONG);
        }
    }



    public void fetchTokenAsync(String authCode, String appSecret) {

        WeiboParameters requestParams = new WeiboParameters(WEIBO_DEMO_APP_KEY);
        requestParams.put(WBConstants.AUTH_PARAMS_CLIENT_ID,     WEIBO_DEMO_APP_KEY);
        requestParams.put(WBConstants.AUTH_PARAMS_CLIENT_SECRET, appSecret);
        requestParams.put(WBConstants.AUTH_PARAMS_GRANT_TYPE,    "authorization_code");
        requestParams.put(WBConstants.AUTH_PARAMS_CODE,          authCode);
        requestParams.put(WBConstants.AUTH_PARAMS_REDIRECT_URL,  REDIRECT_URL);

        // 异步请求，获取 Token
        new AsyncWeiboRunner(getApplicationContext()).requestAsync(OAUTH2_ACCESS_TOKEN_URL, requestParams, "POST", new RequestListener() {
            @Override
            public void onComplete(String response) {
                LogUtil.d(TAG, "Response: " + response);

                // 获取 Token 成功
                Oauth2AccessToken token = Oauth2AccessToken.parseAccessToken(response);
                if (token != null && token.isSessionValid()) {
                    LogUtil.d(TAG, "Success! " + token.toString());

                    mAccessToken = token;
                    //String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(
                           // new java.util.Date(mAccessToken.getExpiresTime()));
                    //String format = getString(R.string.weibosdk_demo_token_to_string_format_1);
                    //mTokenText.setText(String.format(format, mAccessToken.getToken(), date));
                    //mAuthCodeButton.setEnabled(false);

                    Toast.makeText(MainActivity.this,
                            "获取token成功", Toast.LENGTH_SHORT).show();
                } else {
                    LogUtil.d(TAG, "Failed to receive access token");
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                LogUtil.e(TAG, "onWeiboException： " + e.getMessage());
                Toast.makeText(MainActivity.this,
                        "获取token失败", Toast.LENGTH_SHORT).show();
            }
        });
    }



}

package com.chao.load_weibo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

/**
 * Created by chao on 2015/6/1.
 */
public class AuthListener implements WeiboAuthListener {
    private Oauth2AccessToken mAccessToken;
    String mCode;
    String APP_KEY="1141626586";
    String APP_SECRET="4cecc4bd2a7488e999fbb1a06ca04637";
    String REDIRECT_URL="http://www.baidu.com";
    String ACCESS_TOKEN_URL="https://api.weibo.com/oauth2/access_token";
    @Override
    public void onCancel() {
        Log.i("AuthListener","----auth canceled");
    }


    @Override
    public void onComplete(Bundle arg0) {
        // 从 Bundle 中解析 Code
        if (null == arg0) {
            Log.e("AuthListener", "obtain auth code fail!");
            return;
        }

        String code = arg0.getString("code");
        mCode = code;
        if (TextUtils.isEmpty(code)) {
            Log.e("AuthListener", "obtain auth code fail!");
            return;
        }

        //进行授权的下一步
        fetchTokenAsync(mCode, APP_SECRET);//这是异步获取Token
    }

    @Override
    public void onWeiboException(WeiboException arg0){
        Log.i("AuthListener", "----" + arg0.getMessage());
    }
    public void fetchTokenAsync(String authCode, String appSecret) {

        WeiboParameters requestParams = new WeiboParameters();
        requestParams.put("client_id",     APP_KEY);
        requestParams.put("client_secret", appSecret);
        requestParams.put("grant_type",    "authorization_code");
        requestParams.put("code",          authCode);
        requestParams.put("redirect_uri",  REDIRECT_URL);

        // 异步请求，获取 Token
         AsyncWeiboRunner.requestAsync(ACCESS_TOKEN_URL, requestParams, "POST", new RequestListener() {
            @Override
            public void onComplete(String response) {

                System.out.println("Response"+response);

                // 获取 Token 成功，Oauth2AccessToken是一个封装了"access_token"，"expires_in"，"refresh_token"的类
                Oauth2AccessToken token = Oauth2AccessToken.parseAccessToken(response);
                if (token != null && token.isSessionValid()) {

                    System.out.println("Success"+token.toString());

                    mAccessToken = token;
                    System.out.println("授权成功"+token.getToken());

                    //Toast.makeText(OAuthActivity.this,
                           // "授权成功 Token=" + token.getToken(), Toast.LENGTH_SHORT).show();
                } else {
                   System.out.println( "Failed to receive access token");
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                System.out.println( "onWeiboException： " + e.getMessage());
                System.out.println(
                        "授权异常" + e.getMessage());
            }
        });
    }
}

package com.chao.mars_tencent_weiobo;

import android.app.Activity;
import android.os.Bundle;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;

/**
 * Created by chao on 2015/5/19.
 */
public class PrepareRequestTokenActivity  extends Activity{
    private OAuthConsumer consumer;
    private OAuthProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        consumer=new CommonsHttpOAuthConsumer(Constants.CONSUMER_KEY,Constants.CONSUMER_SECRET);
        provider=new CommonsHttpOAuthProvider(Constants.REQUEST_URL,Constants.ACCESS_URL,Constants.AUTHORIZE_URL);

        new OAuthRequestTokenTask(this,consumer,provider).execute();
    }
}

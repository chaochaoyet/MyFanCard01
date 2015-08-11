package com.chao.mars_tencent_weiobo;

import android.content.Context;
import android.os.AsyncTask;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;

/**
 * Created by chao on 2015/5/19.
 */
public class OAuthRequestTokenTask extends AsyncTask<Void,Void,Void>{
    private Context context;
    private OAuthConsumer consumer;
    private OAuthProvider provider;

    public OAuthRequestTokenTask(Context context, OAuthConsumer consumer, OAuthProvider provider) {
        super();
        this.context = context;
        this.consumer = consumer;
        this.provider = provider;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            System.out.println("请求Request Token之前"+consumer.getToken());
            final String url=provider.retrieveRequestToken(consumer,"null");
            System.out.println("请求Request Token之后"+consumer.getToken());
            System.out.println("url--->"+url);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}

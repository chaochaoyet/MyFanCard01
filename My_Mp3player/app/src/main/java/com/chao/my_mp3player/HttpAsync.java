package com.chao.my_mp3player;

/**
 * Created by chao on 2015/4/20.
 */
import android.os.AsyncTask;

/**
 * Created by chao on 2015/4/20.
 */
public class HttpAsync extends AsyncTask {
    private static final String str1 = "http://192.168.1.102:8080/MP3/resources.xml";

    @Override
    protected Object doInBackground(Object[] params) {
        HttpDownloader httpDownloader = new HttpDownloader();
        String lrc = httpDownloader.download(str1);
        return lrc;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        System.out.println("txt------>" + o);
    }
    public String returnXML(Object o){
        return (String)o;
    }
}

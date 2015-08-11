package com.chao.my_mp3player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chao on 2015/4/20.
 */
public class HttpDownloader {

    public String download(String urlstr){
        StringBuffer stringBuffer=new StringBuffer();
        String line=null;
        BufferedReader bufferedReader=null;
        try{
            URL url=new URL(urlstr);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}

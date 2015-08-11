package com.chao.file_download_pj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chao on 2015/4/16.
 */
public class Httpdownload {
    private URL url=null;
    public String download(String urlstr){
        StringBuffer stringBuffer=new StringBuffer();
        String line=null;
        BufferedReader bufferedReader=null;
        try{
            url=new URL(urlstr);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }

        }
        catch (Exception e){
            e.toString();
        }
        return  stringBuffer.toString();
    }
}

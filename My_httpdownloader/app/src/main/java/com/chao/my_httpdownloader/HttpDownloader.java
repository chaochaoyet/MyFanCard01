package com.chao.my_httpdownloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

/**
 * Created by chao on 2015/4/20.
 */
public class HttpDownloader {
    private URL url=null;
    StringBuffer stringBuffer=new StringBuffer();
    String line =null;
    BufferedReader bufferedReader=null;
    public String download(String urlstr){
        try{
            url=new URL(urlstr);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
        return stringBuffer.toString();

    }
    public int downFile(String urlstr,String path,String filename){
        InputStream inputStream=null;
        try{
            Fileutil fileutil=new Fileutil();
            if(fileutil.isFileExist(path+filename)){
                return  1;
            }
            else {
                inputStream=getInputStreamFromUrl(urlstr);
                File resultFile=fileutil.write2SDFromInput(path,filename,inputStream);
                if(resultFile==null){
                    return -1;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;

        }
        finally {
            try{
                inputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }
    public InputStream getInputStreamFromUrl(String urlstr)throws MalformedURLException,IOException{
        url=new URL(urlstr);
        HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
        InputStream inputStream=urlConnection.getInputStream();
        return inputStream;
    }
}

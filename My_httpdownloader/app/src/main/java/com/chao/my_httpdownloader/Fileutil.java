package com.chao.my_httpdownloader;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by chao on 2015/4/20.
 */
public class Fileutil {
    private String SDPATH;
    public String getSDPATH(){
        return  SDPATH;

    }
    public Fileutil(){
        SDPATH= Environment.getExternalStorageDirectory()+"/";
    }
    public File createSDFile(String filename )throws IOException {
        File file=new File(SDPATH+filename);
        file.createNewFile();
        return file;
    }
    public File createSDDir(String dirname){
        File dir=new File(SDPATH+dirname);
        dir.mkdir();
        return  dir;
    }
    public boolean isFileExist(String filename){
        File file=new File(SDPATH+filename);
        return  file.exists();
    }
    public File write2SDFromInput(String  path,String filename,InputStream inputStream){
        File file=null;
        OutputStream outputStream=null;
        try {
            createSDDir(path);
            file=createSDFile(path+filename);
            outputStream=new FileOutputStream(file);
            byte buffer []=new byte[4*1024];
            while(inputStream.read(buffer)!=-1){
                outputStream.write(buffer);
            }
            outputStream.flush();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                outputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return file;
    }
}

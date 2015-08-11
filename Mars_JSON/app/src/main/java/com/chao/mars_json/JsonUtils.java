package com.chao.mars_json;

import android.util.JsonReader;
import android.widget.Toast;

import java.io.StringReader;

/**
 * Created by chao on 2015/5/14.
 */
public class JsonUtils {

    public  void parseJsonArray(String jsonData){
        try{
            JsonReader jsonReader=new JsonReader(new StringReader(jsonData));
            //开始解析数组
            jsonReader.beginArray();
            while(jsonReader.hasNext()){
                //开始解析对象
                jsonReader.beginObject();
                while (jsonReader.hasNext()){
                    //开始解析键值对
                    String tagname=jsonReader.nextName();
                    if(tagname.equals("name")){
                        System.out.println("name_jsonArray-->" + jsonReader.nextString());


                    }
                    else  if(tagname.equals("age")){
                        System.out.println("age_jsonArray-->"+jsonReader.nextInt());

                    }
                }
                //解析对象结束
                jsonReader.endObject();
            }
            //解析数组结束
            jsonReader.endArray();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}

package com.chao.mars_json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by chao on 2015/5/14.
 */
public class JsonUtils_2 {
    public  void parseUsersFromJsonArray(String jsonData){
        Type listType=new TypeToken<LinkedList<User>>(){}.getType();
        Gson gson=new Gson();
        LinkedList<User> users=gson.fromJson(jsonData,listType);
        for(Iterator iterator=users.iterator();iterator.hasNext();){
            User user=(User)iterator.next();
            System.out.println("user_name_jsonArray-->"+user.getName());
            System.out.println("user_age_jsonArray-->"+user.getAge());
        }
    }
}

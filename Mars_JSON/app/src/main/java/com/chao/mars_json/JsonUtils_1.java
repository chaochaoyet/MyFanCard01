package com.chao.mars_json;

import com.google.gson.Gson;

/**
 * Created by chao on 2015/5/14.
 */
public class JsonUtils_1 {
    public  void parseUserFromJson(String jsonData){
        try {
            Gson gson=new Gson();
            User user=gson.fromJson(jsonData,User.class);
            System.out.println("user_name_json-->"+user.getName());
            System.out.println("user_age_json-->"+user.getAge());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

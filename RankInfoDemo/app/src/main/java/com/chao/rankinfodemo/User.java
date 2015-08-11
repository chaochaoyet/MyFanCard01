package com.chao.rankinfodemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by chao on 2015/7/31.
 */
public class User {
    public String user_name;
    public int user_points_total;
    public static User prase(String jsonString){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return User.parse(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static User parse(JSONObject jsonObject){
        if (null == jsonObject) {
            return null;
        }
        User user=new User();
        user.user_name          = jsonObject.optString("username","");
        user.user_points_total        =jsonObject.optInt("points_total");


        return user;

    }
}

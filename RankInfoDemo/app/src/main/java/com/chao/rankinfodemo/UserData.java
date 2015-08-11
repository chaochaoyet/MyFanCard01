package com.chao.rankinfodemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by chao on 2015/7/24.
 */
public class UserData {
    public int code;
    public String message;
    public User user;
    public static UserData prase(String jsonString){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return UserData.parse(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static  UserData parse(JSONObject jsonObject){
        if (null == jsonObject) {
            return null;
        }
        UserData userData=new UserData();
        userData.code                 =jsonObject.optInt("code");
        userData.message              =jsonObject.optString("message");
        userData.user                 = User.parse(jsonObject.optJSONObject("data"));
        return userData;
    }


}

package com.chao.rankinfodemo;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by chao on 2015/7/31.
 */
public class UserList {
    public ArrayList<User> userArrayList;
    public static UserList parse(String jsonString) {
        if (TextUtils.isEmpty(jsonString)) {
            return null;
        }

        UserList userList = new UserList();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);



            JSONArray jsonArray      = jsonObject.optJSONArray("data");
            if (jsonArray != null && jsonArray.length() > 0) {
                int length = jsonArray.length();
                userList.userArrayList = new ArrayList<User>(length);
                for (int ix = 0; ix < length; ix++) {
                    userList.userArrayList.add(User.parse(jsonArray.getJSONObject(ix)));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userList;
    }

}

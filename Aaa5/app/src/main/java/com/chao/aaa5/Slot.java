package com.chao.aaa5;

/**
 * Created by chao on 2015/7/8.
 */
import org.json.*;

import android.content.Context;
import android.os.Bundle;
import com.facebook.SessionLoginBehavior;
import com.facebook.SharedPreferencesTokenCachingStrategy;
import com.facebook.model.GraphUser;

public class Slot {

    private static final String CACHE_NAME_FORMAT = "TokenCache%d";
    private static final String CACHE_USER_ID_KEY = "SwitchUserSampleUserId";
    private static final String CACHE_USER_NAME_KEY = "SwitchUserSampleUserName";

    private String tokenCacheName;
    private String userName;
    private String userId;
    private String gender;
    private SharedPreferencesTokenCachingStrategy tokenCache;
    private SessionLoginBehavior loginBehavior;

    /**
     * 有参构造器
     *
     * @param context
     * @param
     * @param loginBehavior
     */
    public Slot(Context context,  SessionLoginBehavior loginBehavior) {
        this.loginBehavior = loginBehavior;
        this.tokenCacheName = String.format(CACHE_NAME_FORMAT,1);
        this.tokenCache = new SharedPreferencesTokenCachingStrategy(context, tokenCacheName);

        restore();
    }

    /***** Get方法 ****/
    public String getTokenCacheName() {
        return tokenCacheName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getGender() {
        return gender;
    }

    public SessionLoginBehavior getLoginBehavior() {
        return loginBehavior;
    }

    public SharedPreferencesTokenCachingStrategy getTokenCache() {
        return tokenCache;
    }

    /**
     * 对外提供的方法 如果用户为空，直接返回 如果用户不为空，取出用户信息，并保存到本地
     *
     * @param user
     */
    public void update(GraphUser user) {
        if (user == null) {
            return;
        }
        userId = user.getId();
        userName = user.getName();
        try {
            gender = user.getInnerJSONObject().getString("gender");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Bundle userInfo = tokenCache.load();
        userInfo.putString(CACHE_USER_ID_KEY, userId);
        userInfo.putString(CACHE_USER_NAME_KEY, userName);

        tokenCache.save(userInfo);
    }

    /**
     * 对外提供的方法 用于清除用户缓存信息，并同步将用户信息置为空
     */
    public void clear() {
        tokenCache.clear();
        restore();
    }

    /**
     * 取出缓存的用户信息的方法
     */
    private void restore() {
        Bundle userInfo = tokenCache.load();
        userId = userInfo.getString(CACHE_USER_ID_KEY);
        userName = userInfo.getString(CACHE_USER_NAME_KEY);
    }
}
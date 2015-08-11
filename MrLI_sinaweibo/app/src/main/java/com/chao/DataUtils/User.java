package com.chao.DataUtils;

import android.graphics.drawable.Drawable;

/**
 * Created by chao on 2015/5/20.
 */
public class User {
    private long id;
    private String user_id;
    private String user_name;
    private String token;
    private String token_secret;
    private String description;
    private Drawable user_head;

    public User(String user_id, String user_name, String token, String token_secret, String description) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.token = token;
        this.token_secret = token_secret;
        this.description = description;
    }

    public User(String user_id, String user_name, String token, String token_secret, String description, Drawable user_head) {
       this(user_id,user_name,token,token_secret,description);
        this.user_head=user_head;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken_secret() {
        return token_secret;
    }

    public void setToken_secret(String token_secret) {
        this.token_secret = token_secret;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getUser_head() {
        return user_head;
    }

    public void setUser_head(Drawable user_head) {
        this.user_head = user_head;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", token='" + token + '\'' +
                ", token_secret='" + token_secret + '\'' +
                ", description='" + description + '\'' +
                ", user_head=" + user_head +
                '}';
    }
}

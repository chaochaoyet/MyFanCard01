package com.chao.DataUtils;

/**
 * Created by chao on 2015/5/20.
 */

public class DBInfo {
    /**
     * 创建数据库
     */
    public static class DB{
        public static final String DB_NAME="zc_weibo.db";
        public static  final int VERSON=1;
    }

    /**
     * 创建用户表
     */
    public static class Table{
        public static final String USER_TABLE="uesrinfo";
        public static final String _ID="_id";
        public static final String USER_ID="user_id";
        public static final String USER_NAME="user_name";
        public static final String TOKEN="token";
        public static final String TOKEN_SECRET="token_secret";
        public static final String DESCRIPTION="description";
        public static final String USER_HEAD="user_head";
        public static  final String CREATE_USER_TABLE="create table if not exists "
                + USER_TABLE
                +"("
                +_ID+" integer primary key autoincrement, "
                +USER_ID+" text, "
                +USER_NAME+" text, "
                +TOKEN+" text, "
                +TOKEN_SECRET+" text, "
                +DESCRIPTION+" text, "
                +USER_HEAD+" BLOB);";
        /**
         * 删除表空间
         */
        public static final String DROP_USER_TABLE="drop table"+USER_TABLE;
    }
}

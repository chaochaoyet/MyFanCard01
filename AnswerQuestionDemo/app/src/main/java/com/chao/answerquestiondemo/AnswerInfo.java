package com.chao.answerquestiondemo;

import org.json.JSONObject;

/**
 * Created by chao on 2015/8/7.
 */
public class AnswerInfo {
    public int id;
    public String title;
    public String corrent_answer;
    public String wrong_answer1;
    public String wrong_answer2;
    public int batch_id;
    public int category_id;
    public static AnswerInfo parse(String jsonString){
        try{
            JSONObject jsonObject=new JSONObject(jsonString);
            return  AnswerInfo.parse(jsonObject);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
    public  static  AnswerInfo parse(JSONObject jsonObject){
        if(null==jsonObject){
            return null;
        }
        AnswerInfo answerInfo=new AnswerInfo();
        answerInfo.id              =jsonObject.optInt("id");
        answerInfo.title           =jsonObject.optString("title");
        answerInfo.corrent_answer  =jsonObject.optString("current_answer");
        answerInfo.wrong_answer1   =jsonObject.optString("wrong_answer1");
        answerInfo.wrong_answer2   =jsonObject.optString("wrong_answer2");
        answerInfo.batch_id        =jsonObject.optInt("batch_id");
        answerInfo.category_id     =jsonObject.optInt("category_id");

        return answerInfo;
    }
}

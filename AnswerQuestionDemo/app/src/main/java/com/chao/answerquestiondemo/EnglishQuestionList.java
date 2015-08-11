package com.chao.answerquestiondemo;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by chao on 2015/8/7.
 */
public class EnglishQuestionList {
    public ArrayList<AnswerInfo> englishArraylist;
    public static  EnglishQuestionList parse(String jsonString){
        if(TextUtils.isEmpty(jsonString)){
            return  null;
        }
        EnglishQuestionList englishQuestionList=new EnglishQuestionList();
        try{
            JSONObject jsonObject=new JSONObject(jsonString);
            JSONArray jsonArray= jsonObject.optJSONArray("English");
            if(jsonArray != null && jsonArray.length()>0){
                int length= jsonArray.length();
                englishQuestionList.englishArraylist=new ArrayList<AnswerInfo>(length);
                for(int ix=0;ix<length;ix++){
                    englishQuestionList.englishArraylist.add(AnswerInfo.parse(jsonArray.getJSONObject(ix)));
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return englishQuestionList;
    }
}

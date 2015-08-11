package com.chao.myfancard.game_home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chao.myfancard.R;

import com.chao.myfancard.util.UserData;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by chao on 2015/6/10.
 */
public class GameHomeActivity extends Activity implements View.OnClickListener,Runnable {
    private Button info_btn,rank_btn,question_btn,setting_btn,search_btn;
    private TextView user_points,user_total_points,user_name,user_rank;
    private TextView current_time,current_day;
    private int user_id;
    private String baseUrl;
    private String name;
    private int today_points,total_points,rank;
    private UserData userData;
    private RelativeLayout screen,court;
    private android.os.Handler handler;
    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);
        screen=(RelativeLayout)findViewById(R.id.screen);
        court=(RelativeLayout)findViewById(R.id.court);
        BitmapDrawable screen_drawable=new BitmapDrawable(readBitMap(this,R.mipmap.test_screen_zcthree));
        BitmapDrawable court_drawable=new BitmapDrawable(readBitMap(this,R.mipmap.test_bg_zc));
        screen.setBackground(screen_drawable);
        court.setBackground(court_drawable);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        user_id=bundle.getInt("user_id");
        baseUrl="http://ec2-52-27-33-107.us-west-2.compute.amazonaws.com/phpfancard/API/index.php?command=get_user_info&id="+user_id;

        init();
        userinfoGet();
        getCurrentTime();
        getCurrentDay();





    }

    @Override
    public void run() {
        try {
            while(true){
                SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
                String str=sdf.format(new Date());
                handler.sendMessage(handler.obtainMessage(100,str));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void init(){
        current_time=(TextView)findViewById(R.id.current_time);
        current_day=(TextView)findViewById(R.id.current_day);
        user_points=(TextView)findViewById(R.id.user_points);
        user_total_points=(TextView)findViewById(R.id.user_total_points);
        user_name=(TextView)findViewById(R.id.user_name);
        user_rank=(TextView)findViewById(R.id.user_rank);
        info_btn=(Button)findViewById(R.id.info_btn);
        search_btn=(Button)findViewById(R.id.search_btn);
        rank_btn=(Button)findViewById(R.id.rank_btn);
        question_btn=(Button)findViewById(R.id.question_btn);
        setting_btn=(Button)findViewById(R.id.setting_btn);
        info_btn.setOnClickListener(this);
        rank_btn.setOnClickListener(this);
        question_btn.setOnClickListener(this);
        setting_btn.setOnClickListener(this);
        search_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.info_btn:

                //Intent info_intent=new Intent(GameHomeActivity.this, UserInformation.class);
                //Bundle bundle1=new Bundle();
                //bundle1.putInt("user_id",user_id);
                Intent info_intent=new Intent(GameHomeActivity.this,Question.class);

                startActivity(info_intent);


                break;
            case R.id.rank_btn:
                Intent rank_intent=new Intent(GameHomeActivity.this, Rank.class);
                startActivity(rank_intent);

                break;
            case R.id.question_btn:
                Intent question_intent=new Intent(GameHomeActivity.this, Question.class);
                startActivity(question_intent);

                break;
            case R.id.setting_btn:
                Intent setting_intent=new Intent(GameHomeActivity.this, Setting.class);
                startActivity(setting_intent);

                break;
            case R.id.search_btn:
                Intent search_intent=new Intent(GameHomeActivity.this, Search.class);
                startActivity(search_intent);

            default:
                break;
        }

    }
    public static Bitmap readBitMap(Context context, int resId){
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
    private void userinfoGet(){
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET,baseUrl,new RequestCallBack<Object>() {
            @Override
            public void onSuccess(ResponseInfo<Object> objectResponseInfo) {
                userData=UserData.prase(objectResponseInfo.result.toString());
                name=userData.userInfo.user_name;
                today_points=userData.userInfo.user_points_today;
                total_points=userData.userInfo.user_points_total;
                user_name.setText(name);
                user_points.setText(today_points+"");
                user_total_points.setText(total_points+"");
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }
    private void getCurrentTime(){
        handler=new android.os.Handler(){
            public void handleMessage(Message msg) {
                current_time.setText((String) msg.obj);
            }
        };
        new Thread(this).start();





    }
    private void getCurrentDay(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEE", Locale.US);
        String day=simpleDateFormat.format(new Date());
        current_day.setText(day);


    }

}

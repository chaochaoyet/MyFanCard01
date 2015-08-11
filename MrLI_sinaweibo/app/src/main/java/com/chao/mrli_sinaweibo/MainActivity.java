package com.chao.mrli_sinaweibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chao.DataUtils.User;
import com.chao.ToolUtils.UserDao;
import com.chao.ToolUtils.InternetConnect;

import java.util.List;


public class MainActivity extends Activity {
    private LinearLayout linearLayout;
    private Button welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load);
       linearLayout=(LinearLayout)findViewById(R.id.loadImage);
       welcome=(Button)findViewById(R.id.welcome);

        //Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
       //imageView.startAnimation(animation);

         AnimationSet animationSet=new AnimationSet(true);

         AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
         RotateAnimation rotateAnimation=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
         animationSet.addAnimation(alphaAnimation);

         animationSet.addAnimation(rotateAnimation);
         animationSet.setDuration(3000);

        linearLayout.startAnimation(animationSet);

         animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {



            }

            @Override
            public void onAnimationEnd(Animation animation) {
                InternetConnect.checkNetwork(MainActivity.this);




            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });



    }
    public void init(){


         UserDao userDao=new UserDao(MainActivity.this);
         List<User> userList=userDao.findAllUsers();
         if(userList==null || userList.isEmpty()){
         Toast.makeText(MainActivity.this,"没有用户数据",Toast.LENGTH_SHORT).show();
             Intent intent=new Intent();
             intent.setClass(MainActivity.this,OAuthActivity.class);
             MainActivity.this.startActivity(intent);

         //Intent intent=new Intent(MainActivity.this,"");
         }


    }





}

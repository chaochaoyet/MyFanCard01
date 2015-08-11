package com.chao.mrli_sinaweibo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.chao.ToolUtils.OAuth;

/**
 * Created by chao on 2015/5/20.
 */
public class OAuthActivity extends Activity {
    private String callBackUrl="mrli_sinaweibo://OAuthActivity";
    private OAuth oAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oauth);
        View dialogView=View.inflate(OAuthActivity.this,R.layout.oauthdialog,null);
        Animation animation= AnimationUtils.loadAnimation(OAuthActivity.this,R.anim.alpha);
        dialogView.startAnimation(animation);

        Dialog dialog=new Dialog(OAuthActivity.this,R.style.oauth_style);
        dialog.setContentView(dialogView);


        dialog.show();
        Button oauth_start=(Button)dialogView.findViewById(R.id.oauth);
        oauth_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OAuthActivity.this,"认证开始",Toast.LENGTH_SHORT).show();
                //oAuth=OAuth.getInstance();
                //oAuth.requestAccessToken(OAuthActivity.this,callBackUrl);
                Intent intent=new Intent(OAuthActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}

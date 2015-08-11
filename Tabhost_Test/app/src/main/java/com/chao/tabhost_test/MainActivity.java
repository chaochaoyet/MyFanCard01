package com.chao.tabhost_test;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;
import android.app.Service;

/**
 * @author SunnyMiao 2014-4-3下午5:40:53
 *
 */
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements
        OnCheckedChangeListener {

    private TabHost mytab;
    private Intent homeIntent; // 主页
    private Intent mesIntent; // 信息
    private Intent userIntent; // 个人资料
    private long ExitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent it = super.getIntent();
        this.mytab = this.getTabHost();

        this.homeIntent = new Intent(this, WeiboHomeActivity.class);
        this.mesIntent = new Intent(this, WeiboMsgActivity.class);
        this.userIntent = new Intent(this, WeiboUserActivity.class);

        initRadios();
        setupIntent();

    }

    // 初始化按钮
    private void initRadios() {
        // TODO Auto-generated method stub
        ((RadioButton) findViewById(R.id.radiobtn_home))
                .setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radiobtn_msg))
                .setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radiobtn_user))
                .setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO Auto-generated method stub
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.radiobtn_home:
                    this.mytab.setCurrentTabByTag("mblog_tab");
                    break;
                case R.id.radiobtn_msg:
                    this.mytab.setCurrentTabByTag("message_tab");
                    break;
                case R.id.radiobtn_user:
                    this.mytab.setCurrentTabByTag("userinfo_tab");
                    break;

            }
        }

    }

    // 设置Intent
    private void setupIntent() {



        mytab.addTab(mytab.newTabSpec("mblog_tab").setIndicator("mblog_tab")
                .setContent(homeIntent));

        mytab.addTab(mytab.newTabSpec("message_tab")
                .setIndicator("message_tab").setContent(mesIntent));

        mytab.addTab(mytab.newTabSpec("userinfo_tab")
                .setIndicator("userinfo_tab").setContent(userIntent));

    }



}

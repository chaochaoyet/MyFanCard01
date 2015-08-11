package com.chao.mrli_sinaweibo;


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
public class HostActivity extends TabActivity implements
        OnCheckedChangeListener {

    private TabHost mytab;
    private Intent homeIntent; // 主页
    private Intent mesIntent; // 信息
    private Intent userIntent;
    private Intent meIntent;
    private Intent writeIntent;// 个人资料
    private long ExitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host);
        Intent it = super.getIntent();
        this.mytab = this.getTabHost();

        this.homeIntent = new Intent(this, HomeActivity.class);
        this.mesIntent = new Intent(this, MessageActivity.class);
        this.userIntent = new Intent(this, LinkmanActivity.class);
        this.meIntent=new Intent(this,MyInfoActivity.class);
        this.writeIntent=new Intent(this,EditWeioboActivity.class);

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
        ((RadioButton) findViewById(R.id.radiobtn_write))
                .setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radiobtn_me))
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
                case R.id.radiobtn_write:
                    this.mytab.setCurrentTabByTag("editweibo_tab");
                    break;
                case R.id.radiobtn_me:
                    this.mytab.setCurrentTabByTag("myinfo_tab");
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
        mytab.addTab(mytab.newTabSpec("myinfo_tab")
                .setIndicator("myinfo_tab").setContent(meIntent));
        mytab.addTab(mytab.newTabSpec("editweibo_tab")
                .setIndicator("editweibo_tab").setContent(writeIntent));

    }



}
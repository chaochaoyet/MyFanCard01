package com.tabhost_wb;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements
        CompoundButton.OnCheckedChangeListener {

    private TabHost mHost;
    private Intent mMBlogIntent;
    private Intent mMoreIntent;
    private Intent mInfoIntent;
    private Intent mSearchIntent;
    private Intent mUserInfoIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // ~~~~~~~~~~~~ 初始化


        initRadios();

        setupIntent();
    }

    /**
     * 初始化底部按钮
     */
    private void initRadios() {
        ((RadioButton) findViewById(R.id.radio_button0)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button1)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button2)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button3)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button4)).setOnCheckedChangeListener(this);
    }

    /**
     * 切换模块
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.radio_button0:
                    this.mHost.setCurrentTabByTag("mblog_tab");
                    break;
                case R.id.radio_button1:
                    this.mHost.setCurrentTabByTag("message_tab");
                    break;
                case R.id.radio_button2:
                    this.mHost.setCurrentTabByTag("userinfo_tab");
                    break;
                case R.id.radio_button3:
                    this.mHost.setCurrentTabByTag("search_tab");
                    break;
                case R.id.radio_button4:
                    this.mHost.setCurrentTabByTag("more_tab");
                    break;
            }
        }
    }

    private void setupIntent() {
        this.mHost = getTabHost();
        TabHost localTabHost = this.mHost;

        localTabHost.addTab(buildTabSpec("mblog_tab", R.string.main_home,
                R.drawable.photo1, this.mMBlogIntent));

        localTabHost.addTab(buildTabSpec("message_tab", R.string.main_news,
                R.drawable.photo2, this.mInfoIntent));

        localTabHost.addTab(buildTabSpec("userinfo_tab", R.string.main_my_info,
                R.drawable.photo3, this.mUserInfoIntent));

        localTabHost.addTab(buildTabSpec("search_tab", R.string.menu_search,
                R.drawable.photo4, this.mSearchIntent));

        localTabHost.addTab(buildTabSpec("more_tab", R.string.more,
                R.drawable.photo5, this.mMoreIntent));

    }

    private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
                                         final Intent content) {
        return this.mHost
                .newTabSpec(tag)
                .setIndicator(getString(resLabel),
                        getResources().getDrawable(resIcon))
                .setContent(content);
    }
}

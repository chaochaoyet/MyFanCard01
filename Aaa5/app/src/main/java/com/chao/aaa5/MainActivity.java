package com.chao.aaa5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AppEventsLogger;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.SharedPreferencesTokenCachingStrategy;
import com.facebook.model.GraphUser;
import com.facebook.samples.switchuser.R;

public class MainActivity extends FragmentActivity implements OnClickListener {

    private static final String TOKEN_CACHE_NAME_KEY = "TokenCacheName";
    private Slot currentSlot;
    private Session session;
    private Session.StatusCallback sessionStatusCallback;
    public static final String TAG = "SettingsFragment";
    private Button btn;
    private TextView userinfo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userinfo=(TextView)findViewById(R.id.userinfo);
        sessionStatusCallback = new Session.StatusCallback() {
            @Override
            public void call(Session session, SessionState state, Exception exception) {
                onSessionStateChange(session, state, exception);
            }
        };
        SessionLoginBehavior loginBehavior = SessionLoginBehavior.SUPPRESS_SSO;
        currentSlot = new Slot(this, loginBehavior);
        if (savedInstanceState != null) {
            SharedPreferencesTokenCachingStrategy restoredCache = new SharedPreferencesTokenCachingStrategy(this, savedInstanceState.getString(TOKEN_CACHE_NAME_KEY));
            session = Session.restoreSession(this, restoredCache, sessionStatusCallback, savedInstanceState);
        }
        btn = (Button) this.findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    /***
     * Fragment的方法，创建上下文菜单的时候调用
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

    }

    /**
     * 清除Cache的方法
     *
     * @param
     */
    private void clearCache() {
        if (currentSlot.getUserId() != null) {
            currentSlot.clear();
            notifySlotChanged();
        }
    }

    /**
     * 自定义授权按钮
     */
    @Override
    public void onClick(View arg0) {
        notifySlotChanged();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (currentSlot != null) {
            outState.putString(TOKEN_CACHE_NAME_KEY, currentSlot.getTokenCacheName());
        }
        Session.saveSession(session, outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (session != null) {
            session.addCallback(sessionStatusCallback);
        }
        // Call the 'activateApp' method to log an app event for use in
        // analytics and advertising reporting. Do so in
        // the onResume methods of the primary Activities that an app may be
        // launched into.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (session != null) {
            session.removeCallback(sessionStatusCallback);
        }

        // Call the 'deactivateApp' method to log an app event for use in
        // analytics and advertising
        // reporting. Do so in the onPause methods of the primary Activities
        // that an app may be launched into.
        AppEventsLogger.activateApp(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (session != null) {
            session.onActivityResult(this, requestCode, resultCode, data);
        }
    }

    // 授权后的回调的方法
    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            // Log in just happened.
            fetchUserInfo();
        } else if (state.isClosed()) {
            // Log out just happened. Update the UI.
        }
    }

    private void fetchUserInfo() {
        if (session != null && session.isOpened()) {
            Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {
                @Override
                public void onCompleted(GraphUser user, Response response) {
                    if (response.getRequest().getSession() == session) {
                        if (user != null) {
                            Slot s = currentSlot;
                            if (s != null) {
                                s.update(user);
                                userinfo.setText("userinfo\nid:"+s.getUserId()+"\nname:"+s.getUserName());
                                btn.setText("log out");
                                btn.setClickable(false);
                                s.clear();

                            }
                        }
                    }
                }
            });
            request.executeAsync();
        }
    }

    private void handleSlotChange(Slot newSlot) {
        if (session != null) {
            session.close();
            session = null;
        }
        // 对用户进行授权操作，缓存信息保存到Session中
        if (newSlot != null) {
            session = new Session.Builder(this).setTokenCachingStrategy(newSlot.getTokenCache()).build();
            session.addCallback(sessionStatusCallback);

            Session.OpenRequest openRequest = new Session.OpenRequest(this);
            openRequest.setLoginBehavior(newSlot.getLoginBehavior());
            openRequest.setRequestCode(Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
            session.openForRead(openRequest);
        }
    }

    private void notifySlotChanged() {
        handleSlotChange(currentSlot);
    }
}
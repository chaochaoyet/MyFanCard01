package com.chao.popupwindow;

import android.app.ActionBar;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {
    private Button button;
    private TextView textView;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                showPopupWindow();

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.button);



        Timer mTimer=new Timer();
        mTimer.schedule(new initPopupWindow(),100);
    }

    private class initPopupWindow extends TimerTask{
        @Override
        public void run() {
            Message message=new Message();
            message.what=1;
            mHandler.sendMessage(message);
        }
    }


    public void showPopupWindow(){
        Context mContext = MainActivity.this;
        LayoutInflater mInflater=(LayoutInflater)mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        View mView=mInflater.inflate(R.layout.popup_window,null);
        PopupWindow mPopupWindow=new PopupWindow(mView, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.showAtLocation(findViewById(R.id.main), Gravity.CENTER,0,0);
    }

    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("zcerror", ex.toString());
        }
        return null;
    }


}

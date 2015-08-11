package com.chao.ToolUtils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

import com.chao.mrli_sinaweibo.MainActivity;
import com.chao.mrli_sinaweibo.R;

/**
 * Created by chao on 2015/5/19.
 */
public class InternetConnect {
   public static boolean isInternetConnect(Context context){
        ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager==null){
            return false;

        }
        else {
            NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
            if(networkInfos!=null){
                for(NetworkInfo networkInfo :networkInfos){
                    if(networkInfo.getState()==NetworkInfo.State.CONNECTED){
                        return true;
                    }


                }

            }


        }
        return false;
    }
    public static void checkNetwork(final MainActivity context){
        if(!isInternetConnect(context)){
        TextView textView=new TextView(context);
        textView.setText("当前没有可用网络，请连接网络！");
        new AlertDialog.Builder(context)
                .setIcon(R.drawable.photo1)
                .setTitle("网络状态提示")
                .setView(textView)
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));

            }
        }).create().show();
        }
    }
}

    /**
     *  public static void isInternetConnect(Context context){
     ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
     if(connectivityManager==null){
     Toast.makeText(context, "网络错误", Toast.LENGTH_SHORT).show();

     }
     else {
     NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
     if(networkInfos!=null){
     for(NetworkInfo networkInfo :networkInfos){
     if(networkInfo.getState()==NetworkInfo.State.CONNECTED){
     Toast.makeText(context,"网络已连接",Toast.LENGTH_SHORT).show();
     System.out.println("网络已连接");
     }
     else { Toast.makeText(context,"请连接网络",Toast.LENGTH_SHORT).show();}

     }

     }
     else { Toast.makeText(context,"请连接网络",Toast.LENGTH_SHORT).show();}

     }
     }

     *
     */

    /**
     *    public boolean isInternetConnect(){
     ConnectivityManager connectivityManager=(ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
     if(connectivityManager==null){
     return false;

     }
     else {
     NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
     if(networkInfos!=null){
     for(NetworkInfo networkInfo :networkInfos){
     if(networkInfo.getState()==NetworkInfo.State.CONNECTED){
     return true;
     }


     }

     }


     }
     return false;
     }

     * @return
     */


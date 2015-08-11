package com.alert;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Android Alert:");
        alertDialog.setMessage("AlertDialog 提示对话框");

        alertDialog.show();


    }



    
}

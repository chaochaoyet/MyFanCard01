package com.chao.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by chao on 2015/6/23.
 */
public class MyDialog extends Dialog {
    private Context context;

    public MyDialog(Context context) {
        super(context);
        this.context=context;
    }
    public MyDialog(Context context,int theme){
        super(context,theme);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }
}

package com.chao.mrli_sinaweibo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by chao on 2015/5/26.
 */
public class EditWeioboActivity extends Activity{
    private Button cancel,send;
    private EditText weibo_text;
    private EditText getWeibo_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editweibo);
        cancel=(Button)findViewById(R.id.cancel);
        send=(Button)findViewById(R.id.send);
        weibo_text=(EditText)findViewById(R.id.weibo_text);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(weibo_text.getText().toString().equals("")){
                    Intent intent=new Intent(EditWeioboActivity.this,HostActivity.class);
                    startActivity(intent);
                }
                else {
                    new AlertDialog.Builder(EditWeioboActivity.this)
                            .setIcon(null)
                            .setTitle("保存提示：")
                            .setMessage("是否保存")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setNegativeButton("NO",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    weibo_text.setText("");

                                }
                            }).create().show();

                }
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(EditWeioboActivity.this,WeiboListActivity.class);
               Bundle bundle=new Bundle();
               bundle.putString("weibo_text",weibo_text.getText().toString());
              intent.putExtras(bundle);
                EditWeioboActivity.this.startActivity(intent);
                weibo_text.setText("");
            }
        });

    }
}

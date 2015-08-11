package com.chao.mrli_sinaweibo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by chao on 2015/5/21.
 */
public class LoginActivity extends Activity{
    private CharSequence num="123456";
    private  Button log_in;
    private EditText account,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        log_in=(Button)findViewById(R.id.log_in);
        account=(EditText)findViewById(R.id.account);
        password=(EditText)findViewById(R.id.password);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 if(account.getText().toString().equals(num) && password.getText().toString().equals(num)){
                 Toast.makeText(LoginActivity.this,"正确",Toast.LENGTH_SHORT).show();
                     Intent intent=new Intent(LoginActivity.this,HostActivity.class);
                     startActivity(intent);

                 }

                 else {Toast.makeText(LoginActivity.this,"错误:账号（123456）、密码（123456）",Toast.LENGTH_SHORT).show();}



            }

        });

    }
}

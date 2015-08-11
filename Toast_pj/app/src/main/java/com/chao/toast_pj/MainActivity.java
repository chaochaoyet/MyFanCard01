package com.chao.toast_pj;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button button1,button2,button3;
    private EditText editText;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.edit);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button1:
                        if(editText.getText().toString().equals(""))
                            break;
                        Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button2:
                        ImageView imageView=new ImageView(MainActivity.this);
                        imageView.setImageResource(R.drawable.ic_launcher);
                        Toast toast=new Toast(MainActivity.this);
                        toast.setView(imageView);
                        toast.show();
                        break;
                    case R.id.button3:
                        TextView textView=new TextView(MainActivity.this);
                        textView.setText(R.string.toast);
                        Toast toast1=new Toast(MainActivity.this);
                        toast1.setView(textView);
                        toast1.show();
                        break;
                    default:
                        break;

                }
            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);



    }



}

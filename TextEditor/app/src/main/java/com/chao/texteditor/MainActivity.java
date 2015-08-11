package com.chao.texteditor;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainActivity extends ActionBarActivity {

    private EditText filename_edit,filecontent_edit;
    private Button save_button,read_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save_button=(Button)findViewById(R.id.save_button);
        read_button=(Button)findViewById(R.id.read_button);
        filename_edit=(EditText)findViewById(R.id.filename_edit);
        filecontent_edit=(EditText)findViewById(R.id.filecontent_edit);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String file_name=filename_edit.getText().toString();
                if(file_name==""){
                    Toast.makeText(MainActivity.this,"文件名为空",Toast.LENGTH_SHORT).show();

                }
                else {
                    String file_content=filecontent_edit.getText().toString();
                    try {
                        save(file_name,file_content);
                        Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this,"保存失败",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        read_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String file_name=filename_edit.getText().toString();
                if(file_name==""){
                    Toast.makeText(MainActivity.this,"文件名为空",Toast.LENGTH_SHORT).show();

                }
                else {
                    try {
                        String file_content=read(file_name);
                        filecontent_edit.setText(file_content);
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this,"读取失败",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void save(String filename,String filecontent)throws Exception{
        FileOutputStream fileOutputStream=openFileOutput(filename, Context.MODE_WORLD_READABLE);
        fileOutputStream.write(filecontent.getBytes());
    }
    public String read(String filename)throws Exception{
        byte[] buf=new byte[1042];
        int size=0;
        FileInputStream fileInputStream=openFileInput(filename);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        while((size=fileInputStream.read(buf))>0){
            byteArrayOutputStream.write(buf,0,size);
        }
        return  byteArrayOutputStream.toString();
    }



}

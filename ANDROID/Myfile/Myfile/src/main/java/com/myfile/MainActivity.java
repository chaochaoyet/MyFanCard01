package com.myfile;

import android.os.Bundle;
import android.app.Activity;
import android.provider.Browser;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity implements Button.OnClickListener{
    private File file;
    private String path,info,thekey_forminput;
    private TextView show_result;
    private EditText input_editview;
    private Button search_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_result=(TextView)findViewById(R.id.result_textview);
        search_button=(Button)findViewById(R.id.search_button);
        search_button.setOnClickListener(this);
        file=new File("/sdcard");
        info=getString(R.string.info);
    }


        public void onClick(View view) {
        path="";
        show_result.setText("");
        thekey_forminput=input_editview.getText().toString();
        BrowserFile(file);
    }

    public void BrowserFile(File file){
        if(thekey_forminput.equals("")){
            Toast.makeText(MainActivity.this,getString(R.string.pleaseInput),Toast.LENGTH_LONG).show();
        }
        else {
            ToSearchFiles(file);
            if(show_result.getText().equals("")){
                Toast.makeText(MainActivity.this,getString(R.string.notFound),Toast.LENGTH_LONG).show();
            }
        }
    }
    public void ToSearchFiles(File file){
        File[] the_files=file.listFiles();
        for(File tempF : the_files){
            if(tempF.isDirectory()){
                ToSearchFiles(tempF);
            }
            else {
                try{
                    if(tempF.getName().indexOf(thekey_forminput)>-1){
                        path+="\n"+tempF.getPath();
                        show_result.setText(info+path);
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this,getString(R.string.pathError),Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}





    


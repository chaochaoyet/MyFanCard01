package com.chao.phonecall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends ActionBarActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private ImageButton imageButton;
    private static final String[] number=new String[] {"88888888","77777777","66666666","55555555"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autocompletetextview);
        imageButton=(ImageButton)findViewById(R.id.imagebutton);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,number);
        autoCompleteTextView.setAdapter(arrayAdapter);
        imageButton.setBackgroundResource(android.R.drawable.ic_menu_call);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string=autoCompleteTextView.getText().toString();
                String vaild_expression="([0-9]+)$";
                String invaild_expression="([a-zA-Z]+)$";
                if(VaildDigitalPhoneNumber(string,vaild_expression) && !VaildDigitalPhoneNumber
                        (string,invaild_expression)&&VaildNumberLength(string,4,9)){
                    Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+string));
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"无效电话格式",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    public static boolean VaildNumberLength(String phone_number,int minlen,int maxlen){
        int len=phone_number.length();
        if(len>=minlen&&len<=maxlen){
            return true;
        }
        return false;
    }
    public static boolean VaildDigitalPhoneNumber(String phone_number,String regexp){
        Pattern pattern=Pattern.compile(regexp);
        Matcher matcher=pattern.matcher(phone_number);
        if(matcher.matches()){
            return true;
        }
        return false;
    }




}

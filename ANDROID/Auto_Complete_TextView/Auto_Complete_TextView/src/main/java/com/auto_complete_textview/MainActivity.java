package com.auto_complete_textview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import java.net.MulticastSocket;

public class MainActivity extends Activity {
    private AutoCompleteTextView autoCompleteTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    private ArrayAdapter<String> adapter;
    private static String[] cities={"beijing","chengdu","tianjin","chongqing","shanghai","tianhai"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.Auto);
        multiAutoCompleteTextView=(MultiAutoCompleteTextView)findViewById(R.id.Multi);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,cities);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(2);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setThreshold(2);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }



    
}

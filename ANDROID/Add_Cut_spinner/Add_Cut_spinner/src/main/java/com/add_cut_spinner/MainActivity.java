package com.add_cut_spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private TextView show_textview;
    private EditText input_edit;
    private Button add_button,cut_button;
    private Spinner my_spinner;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> city_list;
    private String addstring;
    private String[] cities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_textview=(TextView)findViewById(R.id.show_textview);
        input_edit=(EditText)findViewById(R.id.input_editview);
        add_button=(Button)findViewById(R.id.add_button);
        cut_button=(Button)findViewById(R.id.cut_button);
        my_spinner=(Spinner)findViewById(R.id.select_spinner);
        cities=new String[]{"北京","上海","成都","天津","重庆"};
        city_list=new ArrayList<String>();
        for(int i=0;i<cities.length;i++){
            city_list.add(cities[i]);
        }
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,city_list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my_spinner.setAdapter(arrayAdapter);
        show_textview.setText(arrayAdapter.getItem(0));
        my_spinner.setSelection(0);
        add_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"添加",Toast.LENGTH_LONG).show();
               addstring=input_edit.getText().toString();
               for(int i=0;i<arrayAdapter.getCount();i++){
                   if(addstring.equals(arrayAdapter.getItemId(i))){
                       return;
                   }
                   else if(!addstring.equals("")){


                       arrayAdapter.add(addstring);
                       int post=arrayAdapter.getPosition(addstring);
                       my_spinner.setSelection(post);
                       input_edit.setText("");
                   }


               }
            }
        });
        cut_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(my_spinner.getSelectedItem()!=null){
                    arrayAdapter.remove(my_spinner.getSelectedItem().toString());
                    input_edit.setText("");

                    if(arrayAdapter.getCount()==0){
                        Toast.makeText(MainActivity.this,"删完了",Toast.LENGTH_LONG).show();
                        show_textview.setText("");
                    }
                }
            }
        });
        my_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                show_textview.setText(arrayAdapter.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {






            }
        });




    }



    
}

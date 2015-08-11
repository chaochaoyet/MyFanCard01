package com.spinner_hobby;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView textView;
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] hobbies={"ÀºÇò","×ãÇò","ÅÅÇò"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.hobby_textview);
        spinner=(Spinner)findViewById(R.id.ball_spinner);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,hobbies);
        arrayAdapter.setDropDownViewResource(R.layout.hobbies);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText("ÄãµÄ°®ºÃÊÇ£º"+hobbies[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView.setText("ÄãµÄ°®ºÃÊÇ£º");

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

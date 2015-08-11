package com.chao.tablayouy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TableLayout tableLayout=(TableLayout)findViewById(R.id.tablayout);
        tableLayout.setStretchAllColumns(true);
        for(int i=0;i<3;i++){
            TableRow tableRow=new TableRow(this);
            TextView textView=new TextView(this);
            ImageView imageView=new ImageView(this);
            imageView.setMaxHeight(1);
            imageView.setMaxWidth(1);
            textView.setText("风景");
            imageView.setBackgroundResource(R.drawable.ic_launcher);
            tableRow.addView(imageView);
            tableRow.addView(textView);
            tableLayout.addView(tableRow,new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }



}

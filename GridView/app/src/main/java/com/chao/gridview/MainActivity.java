package com.chao.gridview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private ArrayList<MyGrid> gridlist;
    private SelfAdapter gridadapter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridview);
        try {
            gridlist=new ArrayList<MyGrid>();
            gridadapter=new SelfAdapter(this);
            gridlist.add(new MyGrid("Grid_1"));
            gridlist.add(new MyGrid("Grid_2"));
            gridlist.add(new MyGrid("Grid_3"));
            gridlist.add(new MyGrid("Grid_4"));
            gridlist.add(new MyGrid("Grid_5"));
            gridlist.add(new MyGrid("Grid_6"));
            gridlist.add(new MyGrid("Grid_7"));
            gridlist.add(new MyGrid("Grid_8"));
            gridlist.add(new MyGrid("Grid_9"));
            gridadapter.setList(gridlist);
            gridView.setAdapter(gridadapter);


        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
        }
        finally {

        }

    }



}


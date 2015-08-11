package com.listview02;

import android.app.ListActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import itemperson.person;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<person> persons = new ArrayList<person>();
    private personadapter personAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        personAdapter =new personadapter(MainActivity.this, R.layout.activity_main, persons);
        setListAdapter(personAdapter);
        registerForContextMenu(getListView());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        person person = persons.get(position);
        Toast.makeText(MainActivity.this, person.getId()+":"+person.getName()
                +":"+person.getAge(), Toast.LENGTH_LONG).show();
        return;
    }

    private void initData(){
        persons.add(new person("–Ú∫≈", "–’√˚", "ƒÍ¡‰"));
        persons.add(new person("1", "ljq1", "20"));
        persons.add(new person("2", "ljq2", "20"));
        persons.add(new person("3", "ljq3", "20"));
        persons.add(new person("4", "ljq4", "20"));
        persons.add(new person("5", "ljq5", "20"));
        persons.add(new person("6", "ljq6", "20"));
        persons.add(new person("7", "ljq7", "20"));
        persons.add(new person("8", "ljq8", "20"));
        persons.add(new person("9", "ljq9", "20"));
    }
    
}

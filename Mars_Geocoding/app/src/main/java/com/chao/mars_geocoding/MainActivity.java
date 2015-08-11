package com.chao.mars_geocoding;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {
    private Button geo_button,rgeo_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geo_button=(Button)findViewById(R.id.geo_button);
        rgeo_button=(Button)findViewById(R.id.rgeo_button);
        geo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GeocodeTask().execute();

            }
        });
        rgeo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ReverseGeocodeTask().execute();

            }
        });
    }
    private class GeocodeTask extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected Integer doInBackground(Integer... integers) {
            try {
                Geocoder geocoder=new Geocoder(MainActivity.this, Locale.US);
                List<Address> addresses=geocoder.getFromLocation(40.714224,-73.961452,1);
                for(Iterator iterator=addresses.iterator();iterator.hasNext();){
                    Address address=(Address)iterator.next();
                    System.out.println("address-->"+address);
                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }


    private class ReverseGeocodeTask extends AsyncTask<Integer,Integer,Integer>{
         @Override
         protected Integer doInBackground(Integer... integers) {
             try {
                Geocoder geocoder=new Geocoder(MainActivity.this);
                 List<Address> addresses=geocoder.getFromLocationName("SFO",1);
                 System.out.println("经纬-->"+addresses.size());
             }
             catch (Exception e){
                 e.printStackTrace();
             }
            return null;
     }
    }

}



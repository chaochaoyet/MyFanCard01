package com.chao.mars_location;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private Button button,button_provider,button_best,button_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button_provider=(Button)findViewById(R.id.button_provider);
        button_best=(Button)findViewById(R.id.button_best);
        button_location=(Button)findViewById(R.id.button_location);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationManager locationManager=(LocationManager)MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,new myLocationListener());

            }
        });
        button_provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               LocationManager locationManager=(LocationManager)MainActivity.this.getSystemService(LOCATION_SERVICE);
                List<String> providers=locationManager.getAllProviders();
                for(Iterator iterator=providers.iterator();iterator.hasNext();){
                    String provider=(String)iterator.next();
                    System.out.println("providers-->"+provider);
                    Toast.makeText(MainActivity.this,"providers-->"+provider,Toast.LENGTH_SHORT).show();
                }

            }
        });
        button_best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationManager locationManager=(LocationManager)MainActivity.this.getSystemService(LOCATION_SERVICE);
                Criteria criteria=new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_FINE);
                criteria.setPowerRequirement(Criteria.POWER_LOW);
                criteria.setAltitudeRequired(false);
                criteria.setCostAllowed(false);
                criteria.setSpeedRequired(false);
                String provider=locationManager.getBestProvider(criteria,false);
                System.out.println("best provider-->" + provider);
                Toast.makeText(MainActivity.this,"best provider-->"+provider,Toast.LENGTH_SHORT).show();
            }
        });
        button_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationManager locationManager=(LocationManager)MainActivity.this.getSystemService(LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,1,new myLocationListener());
            }
        });
    }
    private class myLocationListener implements LocationListener{


        @Override
        public void onLocationChanged(Location location) {
            System.out.println(location.getLongitude());
            System.out.println(location.getLatitude());
            Toast.makeText(MainActivity.this,"经度："+location.getLongitude()+"纬度："+location.getLatitude(),Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }




}

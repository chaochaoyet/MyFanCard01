package com.chao.locationdemo;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private TextView latitude,longitude;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitude=(TextView)findViewById(R.id.latitude);
        longitude=(TextView)findViewById(R.id.longitude);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationManager locationManager=(LocationManager)MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,new myLocationListener());
            }
        });


    }


    private class myLocationListener implements LocationListener {


        @Override
        public void onLocationChanged(Location location) {
            System.out.println(location.getLongitude());
            System.out.println(location.getLatitude());
            Toast.makeText(MainActivity.this, "经度：" + location.getLongitude() + "纬度：" + location.getLatitude(), Toast.LENGTH_SHORT).show();
            longitude.setText("经度（longitude）:"+location.getLongitude());
            latitude.setText("纬度（latitude）："+location.getLatitude());

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

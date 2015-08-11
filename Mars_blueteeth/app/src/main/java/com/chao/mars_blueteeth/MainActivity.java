package com.chao.mars_blueteeth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;


public class MainActivity extends ActionBarActivity {
    private Button button,button1,button2;
    private  BluetoothAdapter bluetoothAdapter=null;
    private  BluetoothReceiver bluetoothReceiver=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);

        IntentFilter intentFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        bluetoothReceiver=new BluetoothReceiver();
        registerReceiver(bluetoothReceiver,intentFilter);

        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bluetoothAdapter!=null){
                    Toast.makeText(MainActivity.this,"本机拥有蓝牙设备",Toast.LENGTH_SHORT).show();
                    if(!bluetoothAdapter.isEnabled()){
                        Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivity(intent);
                    }

                    Set<BluetoothDevice> devices=bluetoothAdapter.getBondedDevices();
                    if(devices.size()>0){
                        for(Iterator iterator=devices.iterator();iterator.hasNext();){
                            BluetoothDevice bluetoothDevice=(BluetoothDevice) iterator.next();
                            System.out.println("蓝牙远程设备-->"+bluetoothDevice.getAddress());
                            Toast.makeText(MainActivity.this,bluetoothDevice.getAddress(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    System.out.println("本机没有蓝牙设备");
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent discoverableIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,30);
                startActivity(discoverableIntent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothAdapter.startDiscovery();

            }

        });
    }

    @Override
    protected void onDestroy() {
       unregisterReceiver(bluetoothReceiver);
        super.onDestroy();
    }
}

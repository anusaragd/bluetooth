package com.example.masters.bluetoothtestsoft;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    TextView status;
    String On = "Bluetooth ON";
    String off = "Bluetooth OFF";

    // Key names received from the BluetoothDataService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;



    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            status = (TextView) findViewById(R.id.status);
            BA = BluetoothAdapter.getDefaultAdapter();
            pairedDevices = BA.getBondedDevices();
            // initiate a Switch
            Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
            simpleSwitch.setChecked(false);
            simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                    if (!BA.isEnabled()) {
                        BA.enable();
//                        Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        status.setText(On);
                        status.setTextColor(Color.BLUE);
//                        startActivityForResult(turnOn, 0);
                    } else {
                        BA.disable();
                        status.setText(off);
                        status.setTextColor(Color.RED);
                    }
                }
            });

        }

    public void on(View v) {
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            status.setText(On);
            status.setTextColor(Color.BLUE);
            startActivityForResult(turnOn, 0);
//            Toast.makeText(getApplicationContext(), "Turned on", Toast.LENGTH_LONG).show();
        } else {
//            Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
        }
    }
    public void off(View v){
        BA.disable();
        status.setText(off);
        status.setTextColor(Color.RED);
//        Toast.makeText(getApplicationContext(), "Turned off" ,Toast.LENGTH_LONG).show();
    }


}

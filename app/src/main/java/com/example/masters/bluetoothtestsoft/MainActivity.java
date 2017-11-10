package com.example.masters.bluetoothtestsoft;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    TextView status;
    String On = "Bluetooth ON";
    String off = "Bluetooth OFF";
    Button scan;
    // Key names received from the BluetoothDataService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    public static boolean mOpened = false;
    public static boolean mStop = true;
    private BluetoothDataService mBTService = null;
    public static final int MESSAGE_STOP = 9;
    public static final int MESSAGE_DISABLE_STOP = 13;
    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;

    private ProgressDialog mProgressDlg;

    private ArrayList<BluetoothDevice> mDeviceList = new ArrayList<BluetoothDevice>();

//    private BluetoothAdapter mBluetoothAdapter;
    // Initializes Bluetooth adapter.
//    final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
//    private static final int REQUEST_ENABLE_BT = 1;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//
//            if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
//                Toast.makeText(this, R.string.ble_not_supported, Toast.LENGTH_SHORT).show();
//                finish();
//            }
//            BA = bluetoothManager.getAdapter();
//            if (BA == null || !BA.isEnabled()) {
//                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
//            }
            status = (TextView) findViewById(R.id.status);
            BA = BluetoothAdapter.getDefaultAdapter();
            pairedDevices = BA.getBondedDevices();

            mProgressDlg 		= new ProgressDialog(this);

            mProgressDlg.setMessage("Scanning...");
            mProgressDlg.setCancelable(false);
            mProgressDlg.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                    BA.cancelDiscovery();
                }
            });

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
            scan = (Button) findViewById(R.id.scandrive);
            scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


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

package com.example.masters.bluetoothtestsoft;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;

import java.util.logging.Handler;

/**
 * Activity for scanning and displaying available BLE devices.
 */
public class DeviceScanActivity extends ListActivity {

//    private BluetoothAdapter mBluetoothAdapter;
//    private boolean mScanning;
//    private Handler mHandler;
//
//    // Stops scanning after 10 seconds.
//    private static final long SCAN_PERIOD = 10000;
//    private static final int REQUEST_ENABLE_BT = 1;
//
////    BluetoothAdapter mBluetoothAdapter;
////    final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//
//    // Initializes Bluetooth adapter.
//    final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
//    mBluetoothAdapter =bluetoothManager.getAdapter();
//    // Ensures Bluetooth is available on the device and it is enabled. If not,
//    // displays a dialog requesting user permission to enable Bluetooth.
//    if(mBluetoothAdapter ==null||!mBluetoothAdapter.isEnabled())
//
//
//
//    {
//        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
//    }
//
//
//    private void scanLeDevice(final boolean enable) {
//        if (enable) {
//            // Stops scanning after a pre-defined scan period.
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    mScanning = false;
//                    mBluetoothAdapter.stopLeScan(mLeScanCallback);
//                }
//            }, SCAN_PERIOD);
//
//            mScanning = true;
//            mBluetoothAdapter.startLeScan(mLeScanCallback);
//        } else {
//            mScanning = false;
//            mBluetoothAdapter.stopLeScan(mLeScanCallback);
//        }
//
//    }
//
//    private LeDeviceListAdapter mLeDeviceListAdapter;
//
//    // Device scan callback.
//    private BluetoothAdapter.LeScanCallback mLeScanCallback =
//            new BluetoothAdapter.LeScanCallback() {
//                @Override
//                public void onLeScan(final BluetoothDevice device, int rssi,
//                                     byte[] scanRecord) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            mLeDeviceListAdapter.addDevice(device);
//                            mLeDeviceListAdapter.notifyDataSetChanged();
//                        }
//                    });
//                }
//            };
//
//    private class LeDeviceListAdapter {
//        public void notifyDataSetChanged() {
//            return;
//        }
//
//        public void addDevice(BluetoothDevice device) {
//            device.getBluetoothClass();
//        }
//    }

}
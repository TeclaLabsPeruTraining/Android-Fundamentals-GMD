package com.gmd.lessons;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gmd.lessons.broadcastreceiver.NetworkBroadcastReceiver;
import com.gmd.lessons.broadcastreceiver.NetworkListener;

public class MainActivity extends AppCompatActivity implements NetworkListener {

    private NetworkBroadcastReceiver networkBroadcastReceiver;
    private View vStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);

        networkBroadcastReceiver= new NetworkBroadcastReceiver();
        networkBroadcastReceiver.setNetworkListener(this);
        registerReceiver(networkBroadcastReceiver,intentFilter);
    }

    private void ui() {
        vStatus= findViewById(R.id.vStatus);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(networkBroadcastReceiver!=null){
            unregisterReceiver(networkBroadcastReceiver);
        }
    }

    @Override
    public void wifiOn() {
        vStatus.setBackgroundColor(Color.parseColor("#C0CA33"));
    }

    @Override
    public void wifiOff() {
        vStatus.setBackgroundColor(Color.parseColor("#FF1744"));
    }
}

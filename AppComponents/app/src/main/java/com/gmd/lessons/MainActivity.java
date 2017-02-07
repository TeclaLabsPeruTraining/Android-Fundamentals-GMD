package com.gmd.lessons;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.gmd.lessons.broadcastreceiver.NetworkBroadcastReceiver;
import com.gmd.lessons.broadcastreceiver.NetworkListener;

public class MainActivity extends AppCompatActivity implements NetworkListener {

    private NetworkBroadcastReceiver networkBroadcastReceiver;
    private Button btnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);

        networkBroadcastReceiver= new NetworkBroadcastReceiver();
        networkBroadcastReceiver.setNetworkListener(this);
        //registerReceiver(networkBroadcastReceiver,intentFilter);
    }

    private void ui() {
        btnStatus= (Button)findViewById(R.id.btnStatus);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        registerReceiver(networkBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(networkBroadcastReceiver!=null){
            unregisterReceiver(networkBroadcastReceiver);
        }
    }

    @Override
    public void wifiOn() {
        btnStatus.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
    }

    @Override
    public void wifiOff() {
        btnStatus.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
    }
}

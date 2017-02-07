package com.gmd.lessons.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by eduardomedina on 7/02/17.
 */

public class NetworkBroadcastReceiver extends BroadcastReceiver {

    private NetworkListener networkListener;

    public void setNetworkListener(NetworkListener networkListener) {
        this.networkListener = networkListener;
    }

    public NetworkListener getNetworkListener() {
        return networkListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {

            NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                Log.d("Network", "WIFI ON "+getNetworkListener());
                if(getNetworkListener()!=null){
                    getNetworkListener().wifiOn();
                }

            } else if (networkInfo != null && networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) {
                Log.d("Network", "WIFI OFF "+getNetworkListener());
                if(getNetworkListener()!=null){
                    getNetworkListener().wifiOff();
                }
            }
        }
    }
}

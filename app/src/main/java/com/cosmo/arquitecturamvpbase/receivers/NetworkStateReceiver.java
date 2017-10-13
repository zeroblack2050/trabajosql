package com.cosmo.arquitecturamvpbase.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.cosmo.arquitecturamvpbase.App;

/**
 * Created by Superadmin1 on 13/10/2017.
 */

public class NetworkStateReceiver extends BroadcastReceiver {

    private static boolean connected = false;

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean isConnected;
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED){
            isConnected = false;
        }else {
            isConnected = networkInfo.isConnectedOrConnecting();
        }
        waitAndCheckConnection(isConnected, context);
        connected = isConnected;
    }

    private void waitAndCheckConnection(final boolean isConnected, final Context context) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                App application = (App) context.getApplicationContext();
                if(connected == isConnected && application != null){
                    application.onNetworkStateChanged(isConnected);
                }
            }
        });
        t.start();
    }

    public static boolean isConnected() {
        return connected;
    }
}

package com.cosmo.arquitecturamvpbase;

import android.app.Application;
import android.content.IntentFilter;

import com.cosmo.arquitecturamvpbase.helper.Database;
import com.cosmo.arquitecturamvpbase.receivers.NetworkStateReceiver;
import com.cosmo.arquitecturamvpbase.synchronizer.Synchronizer;

/**
 * Created by jersonsuaza on 9/30/17.
 */

public class App extends Application {

    public static Database mdb;
    private final NetworkStateReceiver NETWORK_STATE_RECEIVER = new NetworkStateReceiver();

    @Override
    public void onCreate() {
        super.onCreate();
        iniDatabase();
        registerNetworkReceiver();
    }

    private void registerNetworkReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(NETWORK_STATE_RECEIVER, filter);
    }

    private void iniDatabase() {
        mdb = new Database(this);
        mdb.open();
    }

    @Override
    public void onTerminate() {
        mdb.close();
        super.onTerminate();
    }

    public void onNetworkStateChanged(boolean isConnected) {
        Synchronizer .getInstance().executeSyncLocalToServer(isConnected);
    }
}

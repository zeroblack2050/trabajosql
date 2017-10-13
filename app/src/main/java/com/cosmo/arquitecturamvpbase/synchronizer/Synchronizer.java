package com.cosmo.arquitecturamvpbase.synchronizer;

import com.cosmo.arquitecturamvpbase.presenter.CreateProductPresenter;
import com.cosmo.arquitecturamvpbase.receivers.NetworkStateReceiver;

import java.util.ArrayList;

/**
 * Created by Superadmin1 on 13/10/2017.
 */

public class Synchronizer {

    private NetworkStateReceiver networkStateReceiver;

    private CreateProductPresenter presenter;

    private static final String TAG = "Synchronizer";
    public static Synchronizer instance = null;


    public static Synchronizer getInstance() {
        if(instance == null){
            instance = new Synchronizer();
        }
        return instance;
    }

    public void executeSyncLocalToServer(boolean isConnected) {


    }
}

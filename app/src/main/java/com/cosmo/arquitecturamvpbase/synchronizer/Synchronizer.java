package com.cosmo.arquitecturamvpbase.synchronizer;

import com.cosmo.arquitecturamvpbase.helper.Database;
import com.cosmo.arquitecturamvpbase.model.Product;
import com.cosmo.arquitecturamvpbase.presenter.CreateProductPresenter;
import com.cosmo.arquitecturamvpbase.receivers.NetworkStateReceiver;
import com.cosmo.arquitecturamvpbase.repository.ProductRepository;

import java.util.ArrayList;

/**
 * Created by Superadmin1 on 13/10/2017.
 */

public class Synchronizer {

    ProductRepository productRepository= new ProductRepository();

    private static final String TAG = "Synchronizer";
    public static Synchronizer instance = null;


    public static Synchronizer getInstance() {
        if(instance == null){
            instance = new Synchronizer();
        }
        return instance;
    }

    public void executeSyncLocalToServer(boolean isConnected) {

        if(isConnected){
            ArrayList<Product> listProducts = Database.productDao.fetchNotSyncProducts();
            for (Product p:listProducts) {
                p.setSync("S");
                productRepository.createProduct(p);
                Database.productDao.updateProduct(p);

            }

        }

    }
}

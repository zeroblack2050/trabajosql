package com.cosmo.arquitecturamvpbase.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.cosmo.arquitecturamvpbase.dao.ProductDao;


/**
 * Created by jersonsuaza on 9/30/17.
 */

public class Database {

    private final Context context;
    private DatabaseHelper dbHelper;

    //DAO´s
    public static ProductDao productDao;

    public Database(Context context) {
        this.context = context;
    }

    public Database open(){
        try{
            dbHelper = new DatabaseHelper(context);
            SQLiteDatabase sdb = dbHelper.getWritableDatabase();

            productDao = new ProductDao(sdb);
            return this;
        }catch (SQLException ex){
            Log.e("SQL OPEN", ex.getMessage());
            throw ex;
        }
    }

    public void close(){
        dbHelper.close();
    }

}

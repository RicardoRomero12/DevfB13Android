package com.example.listas;

/**
 * Created by Richy on 21/02/2017.
 */
import android.app.Application;
import io.realm.Realm;

/**
 * Created by Richy on 21/02/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Realm
        Realm.init(this);
    }
}
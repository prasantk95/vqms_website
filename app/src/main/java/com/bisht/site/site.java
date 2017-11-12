package com.bisht.site;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Rishabh on 5/20/2017.
 */
public class site extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
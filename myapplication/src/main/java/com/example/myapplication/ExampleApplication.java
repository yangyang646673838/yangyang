package com.example.myapplication;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class ExampleApplication extends Application {
    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }
    public static RefWatcher getRefWatcher(Context context){
        ExampleApplication application = (ExampleApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}

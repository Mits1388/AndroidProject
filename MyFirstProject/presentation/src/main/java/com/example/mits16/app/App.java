package com.example.mits16.app;

import android.app.Application;
import android.util.Log;

import com.example.mits16.injection.AppComponent;
import com.example.mits16.injection.AppModule;
import com.example.mits16.injection.DaggerAppComponent;


/**
 * Created by user on 19.03.2018.
 */


public class App extends Application {


    private static AppComponent appComponent;



    public static AppComponent getAppComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("App", "success");
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();



    }
}

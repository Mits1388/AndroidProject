package com.example.mits16.myfirstproject.homework5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;



/**
 * Created by mizz8 on 24.02.2018.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service","onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Service","onDestroy()");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service"," onUnbind()");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Service","onBind()");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service","onStartCommand()");
        someTask();
        return super.onStartCommand(intent, flags, startId);

    }

    void someTask() {

    }
}

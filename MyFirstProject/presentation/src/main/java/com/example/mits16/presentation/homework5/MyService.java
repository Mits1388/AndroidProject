package com.example.mits16.presentation.homework5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;
import java.util.Random;

/**
 * Created by mizz8 on 24.02.2018.
 */

public class MyService extends Service {

    private Toast toast;
    private final IBinder myBinder = new LocalBinder();
    private final Random generator = new Random();


    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service","On Create");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Service","On Destroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        toast = Toast.makeText(getApplicationContext(),"Service onUnbind",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        toast = Toast.makeText(getApplicationContext(),"Service onBind",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return myBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service","On Start Command");
        return super.onStartCommand(intent, flags, startId);

    }

    public int getRandomNumber() {
        return generator.nextInt(100);
    }
}

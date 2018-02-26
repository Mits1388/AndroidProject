package com.example.mits16.myfirstproject.homework5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by mizz8 on 26.02.2018.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

    /*    final String action = intent.getAction();
        if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION))
        {
            if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false))
            {
                Toast.makeText(context,"wifi enabled",Toast.LENGTH_SHORT).show();
                Log.e("AAAA","wifi on");
            }
            else
            {
                Toast.makeText(context,"wifi disabled",Toast.LENGTH_SHORT).show();
                Log.e("AAAA","wifi off");
            }
        }*/
    }
}

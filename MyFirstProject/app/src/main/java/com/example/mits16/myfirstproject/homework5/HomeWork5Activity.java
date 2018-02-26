package com.example.mits16.myfirstproject.homework5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mits16.myfirstproject.R;

/**
 * Created by mizz8 on 23.02.2018.
 */

public class HomeWork5Activity extends AppCompatActivity {

    private ImageView imageView;
    private Button start;
    private Button stop;
    private WifiManager wifiManager;
    private BroadcastReceiver broadcastReceiver;
    boolean bound = false;
    ServiceConnection sConn;
    Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        enableWifi();
        intent = new Intent("com.example.mits16.myfirstproject.homework5.MyService");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(String.valueOf(WifiManager.WIFI_STATE_ENABLED));


        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.d("AAAAA", "MainActivity onServiceConnected");
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                Log.d("AAAA", "MainActivity onServiceDisconnected");
                bound = false;
            }
        };

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                final String action = intent.getAction();
                if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION))
                {
                    if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false))
                    {
                        changeWiFi(R.drawable.ic_signal_wifi_4_bar_black_24dp);
                        Toast.makeText(getApplicationContext(),"wifi enabled",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        changeWiFi(R.drawable.ic_signal_wifi_0_bar_black_24dp);
                        Toast.makeText(getApplicationContext(),"wifi disabled",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiManager.setWifiEnabled(true);
             changeWiFi(R.drawable.ic_signal_wifi_4_bar_black_24dp);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiManager.setWifiEnabled(false);
                changeWiFi(R.drawable.ic_signal_wifi_0_bar_black_24dp);
            }
        });
    }


    public void enableWifi() {
        if (!wifiManager.isWifiEnabled()) {
            changeWiFi(R.drawable.ic_signal_wifi_0_bar_black_24dp);
        }else {
            changeWiFi(R.drawable.ic_signal_wifi_4_bar_black_24dp);
        }
    }



    public void changeWiFi(int image){
        imageView = (ImageView)findViewById(R.id.wifi);
        imageView.setImageResource(image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
       IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);
        enableWifi();
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
        bindService(intent, sConn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();

      //  unregisterReceiver(broadcastReceiver);
       stopService(new Intent(this,MyService.class));
        if (!bound) return;
        unbindService(sConn);
        bound = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);
    }
}

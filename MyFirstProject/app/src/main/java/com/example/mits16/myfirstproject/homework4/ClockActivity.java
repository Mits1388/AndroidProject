package com.example.mits16.myfirstproject.homework4;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



/**
 * Created by mizz8 on 18.02.2018.
 */

public class ClockActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomView customView = new CustomView(this);
        setContentView(customView);
    }
}

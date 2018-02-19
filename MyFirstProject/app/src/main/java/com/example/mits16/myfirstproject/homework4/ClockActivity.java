package com.example.mits16.myfirstproject.homework4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mits16.myfirstproject.R;

import java.util.Date;

/**
 * Created by mizz8 on 18.02.2018.
 */

public class ClockActivity extends AppCompatActivity {

    private Date date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomView customView = new CustomView(this);
        date = new Date();
        setContentView(customView);

    }
}

package com.example.mits16.myfirstproject.homework5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.mits16.myfirstproject.R;

/**
 * Created by mizz8 on 23.02.2018.
 */

public class HomeWork5Activity extends AppCompatActivity {
            private Button button;
            private Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        button = (Button)findViewById(R.id.button8);
        button1 = (Button)findViewById(R.id.button9);
    }
}

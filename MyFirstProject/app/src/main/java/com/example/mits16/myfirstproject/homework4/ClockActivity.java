package com.example.mits16.myfirstproject.homework4;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.mits16.myfirstproject.R;


/**
 * Created by mizz8 on 18.02.2018.
 */

public class ClockActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*CustomView customView = new CustomView(this);
         setContentView(customView);*/
        setContentView(R.layout.activity_clock);
        imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setBackgroundResource(R.drawable.owl);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }
}

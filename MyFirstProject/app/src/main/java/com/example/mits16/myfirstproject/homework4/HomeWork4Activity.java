package com.example.mits16.myfirstproject.homework4;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mits16.myfirstproject.R;


/**
 * Created by mizz8 on 18.02.2018.
 */

public class HomeWork4Activity extends AppCompatActivity{

    private Button startButton;
    private Button stopButton;
    private Button clockButton;
    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.owl);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        startButton = (Button)findViewById(R.id.button4);
        clockButton = (Button)findViewById(R.id.button6);

        clockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeWork4Activity.this, ClockActivity.class);
                startActivity(intent);
            }
        });



        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.start();
            }
        });

        stopButton =(Button) findViewById(R.id.button5);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.stop();
            }
        });


    }

}

package com.example.mits16.presentation;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.example.mits16.presentation.homework4.HomeWork4Activity;
import com.example.mits16.presentation.homework5.HomeWork5Activity;
import com.example.mits16.presentation.homework6.HomeWork6Activity;
import com.example.mits16.presentation.homework7.HomeWork7Activity;
import com.example.mits16.presentation.homework8.HomeWork8Activity;
import com.example.mits16.presentation.homework9.HomeWork9Activity;
import com.example.mits16.presentation.screens.user.UserActivity;

/**
 * Created by mizz8 on 10.02.2018.
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button7);
        button5 = findViewById(R.id.button8);
        button6 = findViewById(R.id.button9);
        button7 = findViewById(R.id.button10);
        button8 = findViewById(R.id.button11);
        button9 = findViewById(R.id.button12);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);


        /*  button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MenuActivity.this, HomeWork1Activity.class);
                    startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, HomeWork2Activity.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button) {
            Intent intent = new Intent(MenuActivity.this, HomeWork1Activity.class);
            startActivity(intent);
        }
       else if ((view.getId() == R.id.button1)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork2Activity.class);
            startActivity(intent);
        } else if ((view.getId() == R.id.button2)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork3Activity.class);
            startActivity(intent);
        } else if ((view.getId() == R.id.button3)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork4Activity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.translate, R.anim.alpha);
        } else if ((view.getId() == R.id.button7)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork5Activity.class);
            startActivity(intent);
        } else if ((view.getId() == R.id.button8)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork6Activity.class);
            startActivity(intent);
        } else if ((view.getId() == R.id.button9)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork7Activity.class);
            startActivity(intent);
        }else if ((view.getId() == R.id.button10)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork8Activity.class);
            startActivity(intent);
        }else if ((view.getId() == R.id.button11)) {
            Intent intent = new Intent(MenuActivity.this, HomeWork9Activity.class);
            startActivity(intent);
        }else if ((view.getId() == R.id.button12)) {
            Intent intent = new Intent(MenuActivity.this, UserActivity.class);
            startActivity(intent);
        }
    }
}

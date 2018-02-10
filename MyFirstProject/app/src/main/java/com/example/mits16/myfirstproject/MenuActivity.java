package com.example.mits16.myfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by mizz8 on 10.02.2018.
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button button;
    private Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);

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

        if(view.getId() == R.id.button ){
            Intent intent = new Intent(MenuActivity.this, HomeWork1Activity.class);
            startActivity(intent);
        }else if((view.getId() == R.id.button1)){
            Intent intent = new Intent(MenuActivity.this, HomeWork2Activity.class);
            startActivity(intent);
        }
    }
}

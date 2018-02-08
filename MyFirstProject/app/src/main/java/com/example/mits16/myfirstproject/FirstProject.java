package com.example.mits16.myfirstproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by mizz8 on 07.02.2018.
 */

public class FirstProject extends AppCompatActivity implements View.OnClickListener {

    private TextView text1;
    private TextView text2;
    private Button but;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        but = findViewById(R.id.button);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exchange();
            }
        });

        text2.setOnClickListener(this);
    }


    public void click (View view){
        exchange();
    }

    @Override
    public void onClick(View view) {
        exchange();
    }

    public void exchange(){
        String first = String.valueOf(text1.getText());
        String second = String.valueOf(text2.getText());
        text1.setText(second);
        text2.setText(first);
    }
}

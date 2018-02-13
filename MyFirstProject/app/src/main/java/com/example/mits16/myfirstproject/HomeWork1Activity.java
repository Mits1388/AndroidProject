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

public class HomeWork1Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView text1;
    private TextView text2;
    private Button button;

    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            exchange();
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exchange();
            }
        });
        text1.setOnClickListener(listener);
        text2.setOnClickListener(this);
    }


   /* public void click (View view){
        exchange();
    }*/

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

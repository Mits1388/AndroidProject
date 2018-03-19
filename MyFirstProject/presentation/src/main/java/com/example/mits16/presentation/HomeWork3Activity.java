package com.example.mits16.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by mizz8 on 13.02.2018.
 */

public class HomeWork3Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageView picture;
    private EditText editText;
    private Button button;
    private TextView textView;
    private String text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework3);

        picture = (ImageView) findViewById(R.id.imageView1);
        editText = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.picture);


        textView = (TextView) findViewById(R.id.textView1);
        text = BuildConfig.API_ENDPOINT;
        textView.setText(text);

        /*String internet = "http://www.youloveit.ru/uploads/gallery/main/162/pikachu.png";
        Glide.with(this).load(editText).into(picture);*/

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String string = editText.getText().toString();
        //Glide.with(this).load(string).into(picture);
        Glide.with(this).load(string).apply(RequestOptions.circleCropTransform()).into(picture); //закругление углов
    }
}

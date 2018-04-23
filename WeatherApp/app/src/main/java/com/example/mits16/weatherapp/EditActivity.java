package com.example.mits16.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ok;
    private EditText editText;
    private String city;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editText = (EditText) findViewById(R.id.edit_text1);
        ok = (Button) findViewById(R.id.ok1);
        ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        city = editText.getText().toString();
        Intent intent = new Intent(EditActivity.this, WeatherActivity.class);
        intent.putExtra("city1", city);
        intent.putExtra("aBoolean", false);
        startActivity(intent);
    }
}

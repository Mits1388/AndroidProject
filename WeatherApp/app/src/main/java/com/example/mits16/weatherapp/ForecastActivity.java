package com.example.mits16.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mits16.weatherapp.adapter.ForecastAdapter;
import com.example.mits16.weatherapp.api.WeatherAPI;
import com.example.mits16.weatherapp.model.forecast.ForecastFiveDay;
import com.example.mits16.weatherapp.model.forecast.ForecastList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mizz8 on 13.03.2018.
 */

public class ForecastActivity extends AppCompatActivity implements View.OnClickListener {

    private WeatherAPI.ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private ForecastAdapter forecastAdapter;
    private List<ForecastList> list;
    private String city;
    private Button buttonForecast;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_forecast);
        buttonForecast = (Button) findViewById(R.id.button_forecast);

        list = new ArrayList<>();
        forecastAdapter = new ForecastAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));


        apiInterface = WeatherAPI.getClient().create(WeatherAPI.ApiInterface.class);
        String units = "metric";
        String key = WeatherAPI.KEY;

        city = getIntent().getStringExtra("city");

        getForecast(city,units,key);
        buttonForecast.setOnClickListener(this);
    }





    public void getForecast(String city,String units, String key) {

        Call<ForecastFiveDay> callForecast = apiInterface.getForecastFiveDay(city, units, key);
        callForecast.enqueue(new Callback<ForecastFiveDay>() {
            @Override
            public void onResponse(Call<ForecastFiveDay> call, Response<ForecastFiveDay> response) {
                Log.e("Forecast", "onResponse");
                ForecastFiveDay data = response.body();

                forecastAdapter.setItemList(data.getList());
                recyclerView.setAdapter(forecastAdapter);


                Log.e("Forecast",data.getCity().getName());
            }

            @Override
            public void onFailure(Call<ForecastFiveDay> call, Throwable t) {
                Log.e("Forecast", "onFailure");
                Log.e("Forecast", t.toString());
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_forecast) {
            Intent intent = new Intent(ForecastActivity.this, WeatherActivity.class);
           // intent.putExtra("city", city);
            startActivity(intent);
        }
    }
}

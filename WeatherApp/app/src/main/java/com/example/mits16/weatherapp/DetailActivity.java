package com.example.mits16.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mits16.weatherapp.adapter.DetailAdapter;
import com.example.mits16.weatherapp.api.WeatherAPI;
import com.example.mits16.weatherapp.model.forecast.ForecastFiveDay;
import com.example.mits16.weatherapp.model.forecast.ForecastList;
import com.example.mits16.weatherapp.model.weather.WeatherDay;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mizz8 on 15.03.2018.
 */

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private DetailAdapter detailAdapter;
    private List<ForecastList> list;
    private TextView day;
    private TextView wind;
    private TextView pressure;
    private TextView humidity;
    private TextView sunrise;
    private TextView sunset;
    private ImageView rise;
    private ImageView imageView;
    private ImageView imageWind;
    private ImageView imagePressure;
    private ImageView imageHumidity;
    private String city;
    private WeatherAPI.ApiInterface apiInterface;
    private TextView descriptionDetail;
    private Button buttonDetail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        day = (TextView) findViewById(R.id.detail_day);
        wind = (TextView) findViewById(R.id.detail_wind);
        pressure = (TextView) findViewById(R.id.detail_pressure);
        humidity = (TextView) findViewById(R.id.detail_humidity);
        sunrise = (TextView) findViewById(R.id.detail_sunrise);
        sunset = (TextView) findViewById(R.id.detail_sunset);
        rise = (ImageView) findViewById(R.id.image_rise);
        imageView = (ImageView) findViewById(R.id.image_view_detail);
        imageWind =(ImageView) findViewById(R.id.image_detail_wind);
        imagePressure =(ImageView) findViewById(R.id.image_detail_pressure);
        imageHumidity = (ImageView) findViewById(R.id.image_detail_humidity);
        recyclerView =(RecyclerView) findViewById(R.id.recycler_detail);
        descriptionDetail = (TextView) findViewById(R.id.description_detail);
        city = getIntent().getStringExtra("city");
        rise.setImageResource(R.drawable.sunrise);
        imageWind.setImageResource(R.drawable.wind);
        imagePressure.setImageResource(R.drawable.pressure);
        imageHumidity.setImageResource(R.drawable.humidity);
        buttonDetail = (Button) findViewById(R.id.button_detail);



        list = new ArrayList<>();
        detailAdapter = new DetailAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        apiInterface = WeatherAPI.getClient().create(WeatherAPI.ApiInterface.class);

        String units = "metric";
        String key = WeatherAPI.KEY;
        getWeather(city,units,key);
        getForecast(city,units,key);
        buttonDetail.setOnClickListener(this);

    }


    public void getWeather(String city, String units,  String key) {

        Call<WeatherDay> callWeather = apiInterface.getWeatherDay(city,units,key);
        callWeather.enqueue(new Callback<WeatherDay>() {
            @Override
            public void onResponse(Call<WeatherDay> call, Response<WeatherDay> response) {
                WeatherDay data = response.body();

                Log.e("AAAA", data.getName());
                wind.setText(String.valueOf(data.getWind().getSpeed()+" m/s"));
                pressure.setText(String.valueOf(data.getMain().getPressure()+"  hPa"));
                humidity.setText(String.valueOf(data.getMain().getHumidity())+" \u0025");

                long SunriseTimeTamp = data.getSys().getSunrise();
                String sunriseTime = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Date(SunriseTimeTamp*1000));
                sunrise.setText(String.valueOf(sunriseTime.toUpperCase()));

                long SunsetTimeTamp = data.getSys().getSunset();
                String sunsetTime = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Date(SunsetTimeTamp*1000));
                sunset.setText(String.valueOf(sunsetTime.toUpperCase()));

                descriptionDetail.setText(data.getWeather().get(0).getDescription().toUpperCase());

                getImageDetail(data);

            }

            @Override
            public void onFailure(Call<WeatherDay> call, Throwable t) {
                Log.e("ForecastWeather", "onFailure");
                Log.e("ForecastWeather", t.toString());
            }
        });

    }

    public void getForecast(String city, String units,  String key) {

        Call<ForecastFiveDay> callForecast = apiInterface.getForecastFiveDay(city, units, key);
        callForecast.enqueue(new Callback<ForecastFiveDay>() {
            @Override
            public void onResponse(Call<ForecastFiveDay> call, Response<ForecastFiveDay> response) {

                ForecastFiveDay data = response.body();

                detailAdapter.setItemList(data.getList());
                recyclerView.setAdapter(detailAdapter);

                long timeTamp = data.getList().get(1).getDt();
                String time = new SimpleDateFormat("EE, dd MMMM", Locale.ENGLISH).format(new Date(timeTamp*1000));
                day.setText(time.toUpperCase());

            }

            @Override
            public void onFailure(Call<ForecastFiveDay> call, Throwable t) {
                Log.e("Forecast", "onFailure");
                Log.e("Forecast", t.toString());
            }
        });
    }





    public void getImageDetail(WeatherDay data){

        if( data.getWeather().get(0).getId() >= 200 && data.getWeather().get(0).getId() <= 232) {
            imageView.setImageResource(R.drawable.storm);
        }else if( data.getWeather().get(0).getId() >= 300 && data.getWeather().get(0).getId() <= 321) {
            imageView.setImageResource(R.drawable.rainovercast);
        }else if( data.getWeather().get(0).getId() >= 500 && data.getWeather().get(0).getId() <= 504) {
            imageView.setImageResource(R.drawable.rainday);
        }else if( data.getWeather().get(0).getId() == 511) {
            imageView.setImageResource(R.drawable.snowday);
        }else if(data.getWeather().get(0).getId() >= 520 && data.getWeather().get(0).getId() <= 531) {
            imageView.setImageResource(R.drawable.rainovercast);
        }else if( data.getWeather().get(0).getId() >= 600 && data.getWeather().get(0).getId() <= 622) {
            imageView.setImageResource(R.drawable.snowday);
        }else if( data.getWeather().get(0).getId() >= 701 && data.getWeather().get(0).getId() <= 781) {
            imageView.setImageResource(R.drawable.fog);
        }else if( data.getWeather().get(0).getId() == 800) {
            imageView.setImageResource(R.drawable.clearskyday);
        }else if( data.getWeather().get(0).getId() == 801) {
            imageView.setImageResource(R.drawable.severalcloudsday);
        }else if(data.getWeather().get(0).getId() == 802) {
            imageView.setImageResource(R.drawable.scatteredclouds);
        }else if( data.getWeather().get(0).getId() == 803 || data.getWeather().get(0).getId() == 804){
            imageView.setImageResource(R.drawable.brokenclouds);
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_detail) {
            Intent intent = new Intent(DetailActivity.this, WeatherActivity.class);
            // intent.putExtra("city", city);
            startActivity(intent);
        }
    }
}

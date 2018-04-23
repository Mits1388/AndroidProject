package com.example.mits16.weatherapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.example.mits16.weatherapp.adapter.WeatherAdapter;
import com.example.mits16.weatherapp.api.WeatherAPI;
import com.example.mits16.weatherapp.model.forecast.ForecastFiveDay;
import com.example.mits16.weatherapp.model.forecast.ForecastList;
import com.example.mits16.weatherapp.model.weather.WeatherDay;

import io.fabric.sdk.android.Fabric;
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
 * Created by mizz8 on 13.03.2018.
 */

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;


    private TextView cityName;
    private TextView temp;
    private TextView tempMin;
    private TextView wind;
    private TextView pressure;
    private TextView humidity;
    private TextView description;
    private ImageView imageWind;
    private ImageView imagePressure;
    private ImageView imageHumidity;
    private ImageView sun;
    private ImageView moon;
    private ImageView view;
    private Button buttonWeather;

    private Button ok;

    private TextView today;
    private String city = "Minsk";

    private String units;
    private String key;
    private ConstraintLayout constraintLayout;
    private LinearLayout linearLayoutDark;
    private WeatherAPI.ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private WeatherAdapter weatherAdapter;
    private List<ForecastList> list;
    private ImageView imageEdit;
    private Boolean aBoolean = true;


    public WeatherActivity() {
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_weather);

        /*
        
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if (pref.getBoolean("is_start", false) != true) {
            setContentView(R.layout.activity_weather);

            getWeather(city,units,key);
            getForecast(city,units,key);

            pref.edit().putBoolean("is_start", true).commit();

        } else {

            setContentView(R.layout.activity_edit);
            city = getIntent().getStringExtra("city");
            getWeather(city,units,key);
            getForecast(city,units,key);

        }
     */

        cityName = (TextView) findViewById(R.id.city) ;
        temp = (TextView) findViewById(R.id.temp_weather);
        tempMin = (TextView) findViewById(R.id.temp_min_weather);
        wind = (TextView) findViewById(R.id.wind_weather);
        pressure = (TextView) findViewById(R.id.pressure_weather);
        humidity = (TextView) findViewById(R.id.humidity_weather);
        description = (TextView) findViewById(R.id.description_weather);
        today = (TextView) findViewById(R.id.today_weather);
        view = (ImageView) findViewById(R.id.image_weather);
        buttonWeather = (Button) findViewById(R.id.button_weather);
        editText = (EditText) findViewById(R.id.edit_text);
        ok = (Button) findViewById(R.id.ok);
        imageWind = (ImageView) findViewById(R.id.image_wind);
        imagePressure  = (ImageView) findViewById(R.id.image_pressure);
        imageHumidity = (ImageView) findViewById(R.id.image_humidity);
        sun = (ImageView) findViewById(R.id.sun);
        moon = (ImageView) findViewById(R.id.moon);
        imageEdit = (ImageView) findViewById(R.id.image_edit);

        imageWind.setImageResource(R.drawable.wind);
        imagePressure.setImageResource(R.drawable.pressure);
        imageHumidity.setImageResource(R.drawable.humidity);

        constraintLayout = (ConstraintLayout) findViewById(R.id.layout_day);


        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);






        list = new ArrayList<>();
        weatherAdapter = new WeatherAdapter();
        apiInterface = WeatherAPI.getClient().create(WeatherAPI.ApiInterface.class);
        units = "metric";
        key  = WeatherAPI.KEY;



       // aBoolean = Boolean.valueOf(getIntent().getStringExtra("aBoolean"));

        getWeather(city,units,key);
        getForecast(city,units,key);


        initRecyclerView();


        constraintLayout.setOnClickListener(this);
        sun.setImageResource(R.drawable.clearskyday);
        moon.setImageResource(R.drawable.clearskynight);
        imageEdit.setImageResource(R.drawable.ic_control_point_black_24dp);

        imageEdit.setOnClickListener(this);
        buttonWeather.setOnClickListener(this);
        ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.layout_day) {
            Intent intent = new Intent(WeatherActivity.this, DetailActivity.class);
            intent.putExtra("city", city);
            startActivity(intent);
        }else if (view.getId() == R.id.button_weather) {
            Intent intent = new Intent(WeatherActivity.this, ForecastActivity.class);
            intent.putExtra("city", city);
            startActivity(intent);
        }else if (view.getId() == R.id.ok) {
                data();
            getWeather(city,units,key);
            getForecast(city,units,key);

        }else if(view.getId() == R.id.image_edit){
            Intent intent = new Intent(WeatherActivity.this, EditActivity.class);
            startActivity(intent);        }else  if (view.getId() == R.id.ok1){
            city = getIntent().getStringExtra("city");
            getWeather(city,units,key);
            getForecast(city,units,key);
        }

    }

    public void data(){
        apiInterface = WeatherAPI.getClient().create(WeatherAPI.ApiInterface.class);
        city =  editText.getText().toString();
        units = "metric";
        key  = WeatherAPI.KEY;
    }



    public void initRecyclerView (){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }




    public void getWeather(String city, String units, String key) {

        Call<WeatherDay> callWeather = apiInterface.getWeatherDay(city,units,key);

        callWeather.enqueue(new Callback<WeatherDay>() {
            @Override
            public void onResponse(Call<WeatherDay> call, Response<WeatherDay> response) {
                Log.e("ForecastWeather", "onResponse");
                WeatherDay data = response.body();

                cityName.setText(data.getName().toUpperCase());

               DecimalFormat decimalFormat = new DecimalFormat("#\u00B0");
               String tempFormat = decimalFormat.format(data.getMain().getTemp());
                               temp.setText(tempFormat+"C");

                DecimalFormat decimalFormatMin = new DecimalFormat("#\u00B0");
               String tempFormatMin = decimalFormatMin.format(data.getMain().getTempMin());
                tempMin.setText(tempFormatMin+"C");

               wind.setText(String.valueOf("wind "+data.getWind().getSpeed()+" m/s"));
               pressure.setText(String.valueOf("pressure "+data.getMain().getPressure()+"  hPa"));
               humidity.setText(String.valueOf("humidity "+data.getMain().getHumidity())+" \u0025");
                description.setText(data.getWeather().get(0).getDescription().toUpperCase());

                getImageWeather(data);
            }

            @Override
            public void onFailure(Call<WeatherDay> call, Throwable t) {
                Log.e("ForecastWeather", "onFailure");
                Log.e("ForecastWeather", t.toString());
            }
        });

    }




    public void getImageWeather(WeatherDay data){

        if( data.getWeather().get(0).getId() >= 200 && data.getWeather().get(0).getId() <= 232) {
            view.setImageResource(R.drawable.storm);
        }else if( data.getWeather().get(0).getId() >= 300 && data.getWeather().get(0).getId() <= 321) {
            view.setImageResource(R.drawable.rainovercast);
        }else if( data.getWeather().get(0).getId() >= 500 && data.getWeather().get(0).getId() <= 504) {
            view.setImageResource(R.drawable.rainday);
        }else if( data.getWeather().get(0).getId() == 511) {
            view.setImageResource(R.drawable.snowday);
        }else if(data.getWeather().get(0).getId() >= 520 && data.getWeather().get(0).getId() <= 531) {
            view.setImageResource(R.drawable.rainovercast);
        }else if( data.getWeather().get(0).getId() >= 600 && data.getWeather().get(0).getId() <= 622) {
            view.setImageResource(R.drawable.snowday);
        }else if( data.getWeather().get(0).getId() >= 701 && data.getWeather().get(0).getId() <= 781) {
            view.setImageResource(R.drawable.fog);
        }else if( data.getWeather().get(0).getId() == 800) {
            view.setImageResource(R.drawable.clearskyday);
        }else if( data.getWeather().get(0).getId() == 801) {
            view.setImageResource(R.drawable.severalcloudsday);
        }else if(data.getWeather().get(0).getId() == 802) {
            view.setImageResource(R.drawable.scatteredclouds);
        }else if( data.getWeather().get(0).getId() == 803 || data.getWeather().get(0).getId() == 804){
            view.setImageResource(R.drawable.brokenclouds);
        }

    }



    public void getForecast(String city, String units, String key) {

        Call<ForecastFiveDay> callForecast = apiInterface.getForecastFiveDay(city, units, key);

        callForecast.enqueue(new Callback<ForecastFiveDay>() {
            @Override
            public void onResponse(Call<ForecastFiveDay> call, Response<ForecastFiveDay> response) {
                Log.e("Forecast", "onResponse");
                ForecastFiveDay data = response.body();


                Log.e("Forecast",data.getCity().getName());

                long timeTamp = data.getList().get(0).getDt();
                String time = new SimpleDateFormat("EE, dd MMMM", Locale.ENGLISH).format(new Date(timeTamp*1000));
                today.setText(time.toUpperCase());

                weatherAdapter.setItemList(data.getList());
                recyclerView.setAdapter(weatherAdapter);
            }

            @Override
            public void onFailure(Call<ForecastFiveDay> call, Throwable t) {
                Log.e("Forecast", "onFailure");
                Log.e("Forecast", t.toString());
            }
        });
      }
    }



   /* private void setWeatherIcon(int actualId, long sunrise, long sunset){
        int id = actualId / 100;
        String icon = "";
        if(actualId == 800){
            long currentTime = new Date().getTime();
            if(currentTime>=sunrise && currentTime<sunset) {
                icon =  getActivity().getString(R.string.weather_sunny);
            } else {
                icon = getActivity().getString(R.string.weather_clear_night);
            }
        } else {
            switch(id) {
                case 2 : icon = getActivity().getString(R.string.weather_thunder);
                    break;
                case 3 : icon = getActivity().getString(R.string.weather_drizzle);
                    break;
                case 7 : icon = getActivity().getString(R.string.weather_foggy);
                    break;
                case 8 : icon = getActivity().getString(R.string.weather_cloudy);
                    break;
                case 6 : icon = getActivity().getString(R.string.weather_snowy);
                    break;
                case 5 : icon = getActivity().getString(R.string.weather_rainy);
                    break;
            }
        }
        weatherIcon.setText(icon);
    }*/





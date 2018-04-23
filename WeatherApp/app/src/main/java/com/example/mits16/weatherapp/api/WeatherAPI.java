package com.example.mits16.weatherapp.api;

import com.example.mits16.weatherapp.model.forecast.ForecastFiveDay;
import com.example.mits16.weatherapp.model.weather.WeatherDay;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mizz8 on 13.03.2018.
 */

public class WeatherAPI {
    public static String KEY = "64ae0a323e09bb73077960d0d2a1f49d";
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;

    public interface ApiInterface {
        @GET("weather")
        Call<WeatherDay> getWeatherDay(
                @Query("q") String city,
                @Query("units") String units,
                @Query("appid") String appid
        );

        @GET("forecast")
        Call<ForecastFiveDay> getForecastFiveDay(
                @Query("q") String city,
                @Query("units") String units,
                @Query("appid") String appid
        );
    }

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}


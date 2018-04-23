package com.example.mits16.weatherapp;

import android.app.Activity;
import android.content.SharedPreferences;

public class CityPreference {

    SharedPreferences preferences;

    public CityPreference(Activity activity){
        preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    String getCity(){
        return preferences.getString("city", "Minsk");
    }

    void setCity(String city){
        preferences.edit().putString("city", city).commit();
    }

}

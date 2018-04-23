package com.example.mits16.weatherapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mits16.weatherapp.R;
import com.example.mits16.weatherapp.model.forecast.ForecastList;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by mizz8 on 22.03.2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ForecastList> list = new ArrayList<>();

    public void setItemList(List<ForecastList> list){
        this.list.clear();

        for (int position = 0; position <= list.size(); position ++ ) {
            if( position == 0){
                this.list.add(list.get(0));
                this.list.add(list.get(8));
                this.list.add(list.get(16));
                this.list.add(list.get(24));
                this.list.add(list.get(32));

             Log.e("text", String.valueOf(list.size()));
            } else {
//                list.remove(position);
      //          notifyItemRemoved(position);
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent,false);
        return new HolderForecast(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        HolderForecast holderForecast = (HolderForecast) holder;


        final ForecastList forecast = list.get(position);

        long dateTamp = forecast.getDt();
        String date = new SimpleDateFormat("EE, dd MMMM", Locale.ENGLISH).format(new Date(dateTamp * 1000));
        holderForecast.dateView.setText(date.toUpperCase());

        DecimalFormat temps = new DecimalFormat("#\u00B0");
        String temp = temps.format(forecast.getMain().getTemp());
        holderForecast.temperatureView.setText(temp);


        holderForecast.descriptionView.setText(forecast.getWeather().get(0).getDescription().toUpperCase(Locale.ENGLISH));
        holderForecast.windView.setText(String.valueOf(forecast.getWind().getSpeed()+" m/s"));
        holderForecast.pressureView.setText(String.valueOf(forecast.getMain().getPressure()+"  hPa"));
        holderForecast.humidityView.setText(String.valueOf(forecast.getMain().getHumidity()+" \u0025"));


        holderForecast.imageWind.setImageResource(R.drawable.wind);
        holderForecast.imagePressure.setImageResource(R.drawable.pressure);
        holderForecast.imageHumidity.setImageResource(R.drawable.humidity);

        getImage(holderForecast,forecast);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class HolderForecast extends RecyclerView.ViewHolder{

        ImageView pictureView;
        TextView dateView;
        TextView  temperatureView;
        TextView  descriptionView;
        TextView  windView;
        TextView  humidityView;
        TextView  pressureView;

        ImageView imageWind;
        ImageView imagePressure;
        ImageView imageHumidity;



        public HolderForecast (View itemView){
            super(itemView);
            Log.e("Adapter","Holder");

            pictureView = itemView.findViewById(R.id.forecast_picture_item);
            dateView = itemView.findViewById(R.id.forecast_date_item);
            temperatureView = itemView.findViewById(R.id.forecast_temp_item);
            descriptionView = itemView.findViewById(R.id.forecast_description_item);
            windView = itemView.findViewById(R.id.forecast_wind_item);
            humidityView = itemView.findViewById(R.id.forecast_humidity_item);
            pressureView = itemView.findViewById(R.id.forecast_pressure_item);

            imageWind = itemView.findViewById(R.id.forecast_wind);
            imagePressure = itemView.findViewById(R.id.forecast_pressure);
            imageHumidity = itemView.findViewById(R.id.forecast_humidity);
        }
    }


    public void getImage(HolderForecast holderForecast, ForecastList forecast){
        if( forecast.getWeather().get(0).getId() >= 200 && forecast.getWeather().get(0).getId() <= 232) {
            holderForecast.pictureView.setImageResource(R.drawable.storm);
        }else if( forecast.getWeather().get(0).getId() >= 300 && forecast.getWeather().get(0).getId() <= 321) {
            holderForecast.pictureView.setImageResource(R.drawable.rainovercast);
        }else if( forecast.getWeather().get(0).getId() >= 500 && forecast.getWeather().get(0).getId() <= 504) {
            holderForecast.pictureView.setImageResource(R.drawable.rainday);
        }else if( forecast.getWeather().get(0).getId() == 511) {
            holderForecast.pictureView.setImageResource(R.drawable.snowday);
        }else if(forecast.getWeather().get(0).getId() >= 520 && forecast.getWeather().get(0).getId() <= 531) {
            holderForecast.pictureView.setImageResource(R.drawable.rainovercast);
        }else if( forecast.getWeather().get(0).getId() >= 600 && forecast.getWeather().get(0).getId() <= 622) {
            holderForecast.pictureView.setImageResource(R.drawable.snowday);
        }else if( forecast.getWeather().get(0).getId() >= 701 && forecast.getWeather().get(0).getId() <= 781) {
            holderForecast.pictureView.setImageResource(R.drawable.fog);
        }else if( forecast.getWeather().get(0).getId() == 800) {
            holderForecast.pictureView.setImageResource(R.drawable.clearskyday);
        }else if( forecast.getWeather().get(0).getId() == 801) {
            holderForecast.pictureView.setImageResource(R.drawable.severalcloudsday);
        }else if(forecast.getWeather().get(0).getId() == 802) {
            holderForecast.pictureView.setImageResource(R.drawable.scatteredclouds);
        }else if( forecast.getWeather().get(0).getId() == 803 || forecast.getWeather().get(0).getId() == 804) {
            holderForecast.pictureView.setImageResource(R.drawable.brokenclouds);
        }
    }

}

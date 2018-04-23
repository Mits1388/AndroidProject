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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by mizz8 on 20.03.2018.
 */

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ForecastList> list = new ArrayList<>();



    public void setItemList(List<ForecastList> lists) {
        Log.e("text", list.toString());
        list.clear();

    for (int position = 0; position <= lists.size(); position ++ ) {
         if( position == 0){
             list.add(lists.get(8));
             list.add(lists.get(16));
             list.add(lists.get(24));
             list.add(lists.get(32));
            Log.e("text", String.valueOf(lists.size()));
        } else {
      //      lists.remove(position);
       //   notifyItemRemoved(position);
        }
    }

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder myHolder = (Holder)holder;
        final ForecastList forecast = list.get(position);

               long monthTamp = forecast.getDt();
               String month  = new SimpleDateFormat("EE", Locale.ENGLISH).format(new Date(monthTamp * 1000));
               myHolder.dateView.setText(month);

               long dateTamp = forecast.getDt();
               String date = new SimpleDateFormat("dd", Locale.ENGLISH).format(new Date(dateTamp * 1000));
               myHolder.dateNumView.setText(date);

               DecimalFormat temps = new DecimalFormat("#\u00B0");
               String temp = temps.format(forecast.getMain().getTemp());
               myHolder.temperatureView.setText(temp+"C");
               getImage(myHolder, forecast);
    }



    @Override
    public int getItemCount() {
       return list.size();
    }



    static class Holder extends RecyclerView.ViewHolder{

        ImageView pictureView;
        TextView dateView;
        TextView  temperatureView;
        TextView dateNumView;

        public Holder (View itemView){
            super(itemView);

            pictureView = itemView.findViewById(R.id.picture_item);
            dateView = itemView.findViewById(R.id.date_item);
           temperatureView = itemView.findViewById(R.id.temperature_item);
            dateNumView = itemView.findViewById(R.id.date_num_item);

        }
    }


    public void getImage(Holder myHolder,ForecastList forecast){

        if( forecast.getWeather().get(0).getId() >= 200 && forecast.getWeather().get(0).getId() <= 232) {
            myHolder.pictureView.setImageResource(R.drawable.storm);
        }else if( forecast.getWeather().get(0).getId() >= 300 && forecast.getWeather().get(0).getId() <= 321) {
            myHolder.pictureView.setImageResource(R.drawable.rainovercast);
        }else if( forecast.getWeather().get(0).getId() >= 500 && forecast.getWeather().get(0).getId() <= 504) {
            myHolder.pictureView.setImageResource(R.drawable.rainday);
        }else if( forecast.getWeather().get(0).getId() == 511) {
            myHolder.pictureView.setImageResource(R.drawable.snowday);
        }else if(forecast.getWeather().get(0).getId() >= 520 && forecast.getWeather().get(0).getId() <= 531) {
            myHolder.pictureView.setImageResource(R.drawable.rainovercast);
        }else if( forecast.getWeather().get(0).getId() >= 600 && forecast.getWeather().get(0).getId() <= 622) {
            myHolder.pictureView.setImageResource(R.drawable.snowday);
        }else if( forecast.getWeather().get(0).getId() >= 701 && forecast.getWeather().get(0).getId() <= 781) {
            myHolder.pictureView.setImageResource(R.drawable.fog);
        }else if( forecast.getWeather().get(0).getId() == 800) {
            myHolder.pictureView.setImageResource(R.drawable.clearskyday);
        }else if( forecast.getWeather().get(0).getId() == 801) {
            myHolder.pictureView.setImageResource(R.drawable.severalcloudsday);
        }else if(forecast.getWeather().get(0).getId() == 802) {
            myHolder.pictureView.setImageResource(R.drawable.scatteredclouds);
        }else if( forecast.getWeather().get(0).getId() == 803 || forecast.getWeather().get(0).getId() == 804) {
            myHolder.pictureView.setImageResource(R.drawable.brokenclouds);
        }


    }




}


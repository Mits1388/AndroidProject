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

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ForecastList> list = new ArrayList<>();

    public void setItemList(List<ForecastList> list){
        this.list.clear();

        for (int position = 0; position <= list.size(); position ++ ) {
            if( position == 0){
               this.list.add(list.get(0));
                this.list.add(list.get(1));
                this.list.add(list.get(2));
                this.list.add(list.get(3));
                this.list.add(list.get(4));
                this.list.add(list.get(5));
                this.list.add(list.get(6));
                this.list.add(list.get(7));
                Log.e("text", list.toString());
            } else {
            //    list.remove(position);
            //    notifyItemRemoved(position);
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent,false);
        return new HolderDetail(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        HolderDetail holderDetail = (HolderDetail) holder;

        final ForecastList forecast = list.get(position);

        long dayTamp = forecast.getDt();
        String day  = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Date(dayTamp * 1000));
        holderDetail.dateView.setText(day);



        DecimalFormat temps = new DecimalFormat("#\u00B0");
        String temp = temps.format(forecast.getMain().getTemp());
        holderDetail.temperatureView.setText(temp);

        getImage(holderDetail, forecast);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    static class HolderDetail extends RecyclerView.ViewHolder{

        ImageView pictureView;
        TextView dateView;
        TextView  temperatureView;

        public HolderDetail (View itemView){
            super(itemView);
            Log.e("Adapter","Holder");

            pictureView = itemView.findViewById(R.id.image_detail);
            dateView = itemView.findViewById(R.id.time_detail);
            temperatureView = itemView.findViewById(R.id.temp_detail);


        }
    }

    public void getImage( HolderDetail holderDetail, ForecastList forecast){
        if( forecast.getWeather().get(0).getId() >= 200 && forecast.getWeather().get(0).getId() <= 232) {
            holderDetail.pictureView.setImageResource(R.drawable.storm);
        }else if( forecast.getWeather().get(0).getId() >= 300 && forecast.getWeather().get(0).getId() <= 321) {
            holderDetail.pictureView.setImageResource(R.drawable.rainovercast);
        }else if( forecast.getWeather().get(0).getId() >= 500 && forecast.getWeather().get(0).getId() <= 504) {
            holderDetail.pictureView.setImageResource(R.drawable.rainday);
        }else if( forecast.getWeather().get(0).getId() == 511) {
            holderDetail.pictureView.setImageResource(R.drawable.snowday);
        }else if(forecast.getWeather().get(0).getId() >= 520 && forecast.getWeather().get(0).getId() <= 531) {
            holderDetail.pictureView.setImageResource(R.drawable.rainovercast);
        }else if( forecast.getWeather().get(0).getId() >= 600 && forecast.getWeather().get(0).getId() <= 622) {
            holderDetail.pictureView.setImageResource(R.drawable.snowday);
        }else if( forecast.getWeather().get(0).getId() >= 701 && forecast.getWeather().get(0).getId() <= 781) {
            holderDetail.pictureView.setImageResource(R.drawable.fog);
        }else if( forecast.getWeather().get(0).getId() == 800) {
            holderDetail.pictureView.setImageResource(R.drawable.clearskyday);
        }else if( forecast.getWeather().get(0).getId() == 801) {
            holderDetail.pictureView.setImageResource(R.drawable.severalcloudsday);
        }else if(forecast.getWeather().get(0).getId() == 802) {
            holderDetail.pictureView.setImageResource(R.drawable.scatteredclouds);
        }else if( forecast.getWeather().get(0).getId() == 803 || forecast.getWeather().get(0).getId() == 804) {
            holderDetail.pictureView.setImageResource(R.drawable.brokenclouds);
        }


    }

}

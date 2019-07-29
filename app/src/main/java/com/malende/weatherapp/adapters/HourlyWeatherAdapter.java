package com.malende.weatherapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malende.weatherapp.R;
import com.malende.weatherapp.models.HourlyWeather;
import com.malende.weatherapp.utils.Time;

import java.util.List;

public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.HourlyWeatherViewHolder> {

    private List<HourlyWeather> hourlyWeatherList;

    public HourlyWeatherAdapter(List<HourlyWeather> hourlyWeatherList){
        this.hourlyWeatherList = hourlyWeatherList;
    }

    @NonNull
    @Override
    public HourlyWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.hour_weather_item,viewGroup,false);

        return new HourlyWeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyWeatherViewHolder hourlyWeatherViewHolder, int i) {
        HourlyWeather weather = hourlyWeatherList.get(i);
        String summaryText = weather.getTemperature() + " / " +weather.getSummary();
        String timeText = Time.getTimeString(weather.getTime());

        hourlyWeatherViewHolder.summaryView.setText(summaryText);
        hourlyWeatherViewHolder.timeView.setText(timeText);
    }

    @Override
    public int getItemCount() {
        return hourlyWeatherList.size();
    }

    public class HourlyWeatherViewHolder extends RecyclerView.ViewHolder{

        protected TextView summaryView;
        protected TextView timeView;

        public HourlyWeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            summaryView = itemView.findViewById(R.id.text_status);
            timeView = itemView.findViewById(R.id.text_hour);

        }
    }
}

package com.malende.weatherapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.malende.weatherapp.R;
import com.malende.weatherapp.adapters.HourlyWeatherAdapter;
import com.malende.weatherapp.models.HourlyWeather;
import com.malende.weatherapp.presenters.WeatherStatusPresenter;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity implements WeatherView{

     private TextView weatherStatus;
     private RecyclerView recyclerView;
     private WeatherStatusPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherStatus = findViewById(R.id.weather_status);

        recyclerView = findViewById(R.id.hourly_weather_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        presenter = new WeatherStatusPresenter(this);
        presenter.getWeather();

    }

    @Override
    public void currentWeatherStatus(String status, double temperature) {
        String summary = temperature +" / "+ status;
        weatherStatus.setText(summary);
    }

    @Override
    public void hourlyWeatherStatus(List<HourlyWeather> hourlyWeatherList) {
        HourlyWeatherAdapter adapter = new HourlyWeatherAdapter(hourlyWeatherList);
        recyclerView.setAdapter(adapter);
    }


}

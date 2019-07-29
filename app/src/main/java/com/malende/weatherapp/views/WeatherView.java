package com.malende.weatherapp.views;

import com.malende.weatherapp.models.HourlyWeather;

import java.util.List;

public interface WeatherView {

    void currentWeatherStatus(String summary, double temperature);

    void hourlyWeatherStatus(List<HourlyWeather> hourlyWeatherList);
}

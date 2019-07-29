package com.malende.weatherapp.service;

import com.malende.weatherapp.models.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherAPI {

    @GET("42.3601,-71.0589")
        Call<APIResponse> getCityWeather();
}

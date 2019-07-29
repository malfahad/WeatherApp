package com.malende.weatherapp.service;


import com.malende.weatherapp.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPIService {

    private static Retrofit instance;
    private static String BASE_URL = "https://api.darksky.net/forecast/"+ BuildConfig.API_KEY +"/";

    public static WeatherAPI getAPIInstance () {

        if(instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance.create(WeatherAPI.class);
    }



}

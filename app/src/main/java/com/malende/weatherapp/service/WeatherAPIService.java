package com.malende.weatherapp.service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPIService {

    private static Retrofit instance;
    private static String BASE_URL = "https://api.darksky.net/forecast/1ae0dd6cce3e1d885ca717539873304d/";

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

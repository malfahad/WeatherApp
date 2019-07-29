package com.malende.weatherapp.presenters;

import android.util.Log;

import com.malende.weatherapp.models.APIResponse;
import com.malende.weatherapp.models.Currently;
import com.malende.weatherapp.models.Hourly;
import com.malende.weatherapp.service.WeatherAPIService;
import com.malende.weatherapp.service.WeatherAPI;
import com.malende.weatherapp.views.WeatherView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherStatusPresenter {

    private WeatherAPI service;
    private WeatherView weatherView;

    public WeatherStatusPresenter(WeatherView weatherView) {

        if(service == null) {
            service = WeatherAPIService.getAPIInstance();
        }
        this.weatherView = weatherView;
    }



    public void getWeather() {
        final String TAG = "GET_WEATHER";
        service.getCityWeather().enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

                Currently currently = null;
                Hourly hourly = null;
                if(response!= null){
                    APIResponse apiResponse = response.body();
                    if(apiResponse != null) {
                        currently = apiResponse.getCurrently();
                        hourly = apiResponse.getHourly();
                    }
                }
                if(currently != null){
                    weatherView.currentWeatherStatus(currently.getSummary(), currently.getTemperature());
                }
                if(hourly != null) {
                    weatherView.hourlyWeatherStatus(hourly.getData());
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.e(TAG,t.getLocalizedMessage());
            }
        });
    }



}

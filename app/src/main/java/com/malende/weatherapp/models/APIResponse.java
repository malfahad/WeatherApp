package com.malende.weatherapp.models;

public class APIResponse {

    private Currently currently;
    private Hourly hourly;

    public Hourly getHourly() {
        return hourly;
    }

    public Currently getCurrently() {
        return currently;
    }

}

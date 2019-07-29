package com.malende.weatherapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    public static String getTimeString(long time) {
        Date date = new Date();
        date.setTime(time*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:MM");
        return dateFormat.format(date);
    }
}

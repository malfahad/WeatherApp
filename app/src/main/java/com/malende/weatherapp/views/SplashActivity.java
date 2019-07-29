package com.malende.weatherapp.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.malende.weatherapp.R;

public class SplashActivity extends AppCompatActivity implements Runnable{

    private Handler navigationHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        navigationHandler = new Handler();
        navigationHandler.postDelayed(this, 2000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigationHandler.removeCallbacks(this);
    }

    @Override
    public void run() {
        Intent intent = new Intent(SplashActivity.this, WeatherActivity.class);
        startActivity(intent);
        finish();
    }
}

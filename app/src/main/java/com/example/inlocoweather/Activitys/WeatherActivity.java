package com.example.inlocoweather.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.inlocoweather.R;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Bundle params = getIntent().getExtras();

        Log.i("WeatherActivity", "onCreate: "+ params.get("weather"));
    }
}

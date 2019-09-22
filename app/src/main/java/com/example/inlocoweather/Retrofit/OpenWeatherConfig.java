package com.example.inlocoweather.Retrofit;

import android.content.Context;
import android.util.Log;

import com.example.inlocoweather.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenWeatherConfig {

    private final Retrofit retrofit;

    public OpenWeatherConfig(Context ctx) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(ctx.getResources().getString(R.string.weather_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public OpenWeatherService getOpenWeatherService(){
        return this.retrofit.create(OpenWeatherService.class);
    }
}

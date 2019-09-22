package com.example.inlocoweather.Listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.inlocoweather.Activitys.WeatherActivity;
import com.example.inlocoweather.Models.WeatherResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetByLatLonResponse implements Callback<WeatherResponse> {

    private Activity activity;

    public GetByLatLonResponse(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

        if(response.body() == null) {
            Toast.makeText(activity.getApplicationContext(),
                    "Não consegui encontrar sua cidade", Toast.LENGTH_LONG).show();
        }else{
            String objPram = new Gson().toJson(response.body());
            Intent it = new Intent(activity, WeatherActivity.class);
            it.putExtra("weather", objPram);
            activity.startActivity(it);
        }

    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        Toast.makeText(activity.getApplicationContext(),
                "Algo esta errado, verifique o log.", Toast.LENGTH_LONG).show();
        t.printStackTrace();
    }
}

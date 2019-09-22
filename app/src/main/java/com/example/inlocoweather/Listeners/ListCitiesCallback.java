package com.example.inlocoweather.Listeners;

import com.example.inlocoweather.Activitys.ListWeatherActivity;
import com.example.inlocoweather.Models.ListWeathers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCitiesCallback implements Callback<ListWeathers> {

    CallbackFromResponse<ListWeathers> responseListWeathers;

    public ListCitiesCallback(CallbackFromResponse<ListWeathers> responseListWeathers) {
        this.responseListWeathers = responseListWeathers;
    }

    @Override
    public void onResponse(Call<ListWeathers> call, Response<ListWeathers> response) {

        responseListWeathers.callbackFromResponse(response.body());

    }

    @Override
    public void onFailure(Call<ListWeathers> call, Throwable t) {
        t.printStackTrace();
    }
}

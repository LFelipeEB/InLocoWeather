package com.example.inlocoweather.Retrofit;

import com.example.inlocoweather.Models.ListWeathers;
import com.example.inlocoweather.Models.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherService {

    @GET("weather")
    Call<WeatherResponse> getByLatLon(
            @Query("lat") double latitude,
            @Query("lon")  double longitude,
            @Query("appid") String appId
    );

    @GET("find")
    Call<ListWeathers> getCycle(
            @Query("lat") double latitude,
            @Query("lon")  double longitude,
            @Query("cnt") int cnt,
            @Query("units") String units,
            @Query("appid") String appId
    );

}

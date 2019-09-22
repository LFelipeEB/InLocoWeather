package com.example.inlocoweather.Listeners;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.inlocoweather.Activitys.MapsActivity;
import com.example.inlocoweather.Models.WeatherResponse;
import com.example.inlocoweather.R;
import com.example.inlocoweather.Retrofit.OpenWeatherConfig;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;

public class OnClickMap implements GoogleMap.OnMapClickListener{

    private GoogleMap mMap;
    private Context ctx;
    private Activity activity;
    private MarkerOptions markerOptions;

    public OnClickMap(GoogleMap mMap, Activity activity) {
        this.mMap = mMap;
        this.ctx = activity.getApplicationContext();
        this.activity = activity;
    }

    @Override
    public void onMapClick(LatLng latLng) {

        mMap.addMarker(new MarkerOptions().position(latLng));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        MapsActivity.setLatLngGlobal(latLng);

        TextView tvLat = activity.findViewById(R.id.tvLat);
        tvLat.setText(Double.toString(MapsActivity.getLatLngGlobal().latitude));

        TextView tvLon = activity.findViewById(R.id.tvLon);
        tvLon.setText(Double.toString(MapsActivity.getLatLngGlobal().longitude));

//        getWeatherFromLatLon(latLng.latitude, latLng.longitude);
    }

    private void getWeatherFromLatLon(double lat, double lon){
        Call<WeatherResponse> getWeather= new OpenWeatherConfig(ctx).getOpenWeatherService()
                .getByLatLon(lat, lon,
                        ctx.getResources().getString(R.string.weather_api_key));

        getWeather.enqueue(new GetByLatLonResponse(activity));
    }

}

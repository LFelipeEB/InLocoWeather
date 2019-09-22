package com.example.inlocoweather.Activitys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inlocoweather.Helpers.AdapterWeather;
import com.example.inlocoweather.Listeners.CallbackFromResponse;
import com.example.inlocoweather.Listeners.ListCitiesCallback;
import com.example.inlocoweather.Models.ListWeathers;
import com.example.inlocoweather.Models.WeatherResponse;
import com.example.inlocoweather.R;
import com.example.inlocoweather.Retrofit.OpenWeatherConfig;

import java.util.List;

import retrofit2.Call;

public class ListWeatherActivity extends AppCompatActivity implements CallbackFromResponse<ListWeathers> {

    private ListWeathers listResponse;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_weather);

        progressBar = findViewById(R.id.listProgressBar);

        Bundle params = getIntent().getExtras();
        getListCities(params.getDouble("lat"), params.getDouble("lon"));

    }

    private void getListCities(double lat, double lon){
        Call<ListWeathers> callListCities = new OpenWeatherConfig(this).getOpenWeatherService()
                .getCycle(lat, lon, 15, "metric",
                        getResources().getString(R.string.weather_api_key));

        callListCities.enqueue(new ListCitiesCallback(this));
    }


    @Override
    public void callbackFromResponse(ListWeathers body) {
        progressBar.setVisibility(View.GONE);
        listResponse = body;

        Log.i("ListWeatherActivity", "callbackFromResponse: -> "+listResponse.toString());

        recyclerView = findViewById(R.id.recycleViewList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new AdapterWeather(listResponse);
        recyclerView.setAdapter(mAdapter);
    }

}

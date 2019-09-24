package com.example.inlocoweather.Helpers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inlocoweather.Models.ListWeathers;
import com.example.inlocoweather.Models.WeatherResponse;
import com.example.inlocoweather.R;

import java.util.List;

public class AdapterWeather extends RecyclerView.Adapter<WeatherViewHolder>{

    private List<WeatherResponse> weathers;

    public AdapterWeather(ListWeathers listResponse) {
        weathers = listResponse.getList();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_recycleview, parent, false);

        WeatherViewHolder viewHolder = new WeatherViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherResponse weather = weathers.get(position);

        TextView tvName = holder.tvName;
        tvName.setText(weather.getName());
        TextView tvTempMax = holder.tvTempMax;
        tvTempMax.setText("Max: "+ Float.toString(weather.getMain().getTempMax()));
        TextView tvTempMin = holder.tvTempMin;
        tvTempMin.setText("Min: "+ Float.toString(weather.getMain().getTempMin()));
        TextView tvDescription = holder.tvDescription;
        tvDescription.setText(weather.getWeather()[0].getDescription());

    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

}
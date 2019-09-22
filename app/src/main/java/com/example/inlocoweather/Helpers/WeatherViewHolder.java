package com.example.inlocoweather.Helpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inlocoweather.R;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    public TextView tvName;
    public TextView tvTempMax;
    public TextView tvTempMin;
    public TextView tvDescription;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.rvTvName);
        tvTempMax = itemView.findViewById(R.id.rvTvTempMax);
        tvTempMin = itemView.findViewById(R.id.rvTvTempMin);
        tvDescription = itemView.findViewById(R.id.rvTvDescription);

    }

}
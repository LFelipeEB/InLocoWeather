package com.example.inlocoweather.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.example.inlocoweather.Listeners.OnClickMap;
import com.example.inlocoweather.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private static LatLng latLngGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapClickListener(new OnClickMap(mMap, this));

    }

    public static LatLng getLatLngGlobal(){
        return MapsActivity.latLngGlobal;
    }

    public static LatLng setLatLngGlobal(LatLng latLng){
        MapsActivity.latLngGlobal = latLng;
        return MapsActivity.latLngGlobal;
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, ListWeatherActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("lat", latLngGlobal.latitude);
        bundle.putDouble("lon", latLngGlobal.longitude);
        it.putExtras(bundle);
        startActivity(it);
    }
}

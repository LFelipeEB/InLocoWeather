package com.example.inlocoweather.Activitys;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.inlocoweather.Listeners.OnClickMap;
import com.example.inlocoweather.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.inlocomedia.android.core.permissions.PermissionResult;
import com.inlocomedia.android.core.permissions.PermissionsListener;
import com.inlocomedia.android.engagement.InLocoEngagement;
import com.inlocomedia.android.location.InLoco;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private static LatLng latLngGlobal;

    private final static String[] REQUIRED_PERMISSIONS = { Manifest.permission.ACCESS_FINE_LOCATION };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);

        final boolean askIfDenied = true;

        InLocoEngagement.requestPermissions(this, REQUIRED_PERMISSIONS, askIfDenied, permissionListener());

        InLocoEngagement.givePrivacyConsent(this, true);
    }

    private PermissionsListener permissionListener() {
        return new PermissionsListener() {
            @Override
            public void onPermissionRequestCompleted(HashMap<String, PermissionResult> hashMap) {
                if (hashMap.get(Manifest.permission.ACCESS_FINE_LOCATION).isAuthorized()) {
                    Log.i("MapsActivity", "onPermissionRequestCompleted: -> Permission Enable");
                }else{
                    Log.i("MapsActivity", "onPermissionRequestCompleted: -> Permission Disable");
                }
            }
        };
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

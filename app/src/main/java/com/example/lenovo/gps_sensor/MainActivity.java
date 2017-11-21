package com.example.lenovo.gps_sensor;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    TextView lat, longi, srce;
    String provider="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lat = (TextView) findViewById(R.id.lat);
        longi = (TextView) findViewById(R.id.longi);
        srce = (TextView) findViewById(R.id.source);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        provider =locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            srce.setText("Source = " + provider);
            onLocationChanged(location);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onLocationChanged(Location location) {
        double lati = location.getLatitude();
        double lng = location.getLongitude();
        lat.setText(String.valueOf(lati));
        longi.setText(String.valueOf(lng));
        srce.setText("Source = " + provider);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        srce.setText("Source = " + provider);
    }

    @Override
    public void onProviderEnabled(String s) {
        srce.setText("Source = " + provider);
    }

    @Override
    public void onProviderDisabled(String s) {
        srce.setText("Source = " + provider);
    }
}

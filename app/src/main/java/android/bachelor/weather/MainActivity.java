package android.bachelor.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.bachelor.weather.Data.FetchData;
import android.bachelor.weather.Models.Daily;
import android.bachelor.weather.Models.WeatherData;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.List;


public class MainActivity extends AppCompatActivity implements ICallbackListener , Adapter.AdapterOnClickHandler, LocationListener {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private CurrentPosFragment frag;
    private Boolean isGpsEnabled = false;
    private static final int REQUEST_LOCATION = 123;
    private double longitude = -73.935242;//9.394911;
    private double latitude = 40.730610;//56.428888;
    private Boolean isLoading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    }, REQUEST_LOCATION);
        } else {
            System.out.println("Location permissions available, starting location");
            isGpsEnabled = true;
        }

        // If gps is enabled get Location
        if(isGpsEnabled) {
            GetLocation();
        }

        //  Getting recyclerview by ID from layout
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        // Set empty data to avoid crash
        WeatherData data = new WeatherData();
        adapter = new Adapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if(requestCode == REQUEST_LOCATION) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                System.out.println("Location permissions granted, starting location");
                GetLocation();
            }
        }
    }

    private void GetLocation() {
        try{
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,400,1,this);
            Location location = null;

            location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location == null){
                Toast.makeText(this,"Location Not found",Toast.LENGTH_LONG).show();
            }else{
                try {
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();
                    System.out.println("Found device lat: " + latitude + ", long: "+ longitude);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lm.removeUpdates(this);

            FetchData fetchData = new FetchData(longitude, latitude);
            fetchData.setCallbackListener(this);
            fetchData.execute("");

        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void callback(WeatherData weatherData) {
        adapter.Clear();
        adapter.AddData(weatherData);
        adapter.notifyDataSetChanged();
        if(frag != null) {
            frag.setData(weatherData.getPlaceImage(), weatherData.getPlaceName(), String.valueOf((int) weatherData.getCurrent().getTemp()), weatherData.getDaily().get(0).getWeather().get(0).getDescription());
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if(fragment instanceof CurrentPosFragment) {
            this.frag = (CurrentPosFragment)fragment;
        }
    }

    @Override
    public void onClick(Daily dailyData, WeatherData metadata) {
        Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
        detailIntent.putExtra("DAILY" , dailyData);
        detailIntent.putExtra("META", metadata);
        startActivity(detailIntent);
    }

    @Override
    public void onLocationChanged(Location location) {
        System.out.println("");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        System.out.println("");
    }

    @Override
    public void onProviderEnabled(String provider) {
        System.out.println("");
    }

    @Override
    public void onProviderDisabled(String provider) {
        System.out.println("");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        System.out.println("");
    }
}


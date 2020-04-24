package android.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.example.weather.Data.FetchData;
import android.example.weather.Models.Daily;
import android.example.weather.Models.DateTypeAdapter;
import android.example.weather.Models.Weather;
import android.example.weather.Models.WeatherData;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements ICallbackListener , Adapter.AdapterOnClickHandler {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Getting recyclerview by ID from layout
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        WeatherData data = new WeatherData();

        adapter = new Adapter(data, this);
        FetchData fetchData = new FetchData();
        fetchData.setCallbackListener(this);
        fetchData.execute("");
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void callback(WeatherData weatherData) {
        adapter.Clear();
        adapter.AddData(weatherData);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(Daily dailyData) {
        Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
        detailIntent.putExtra("DAILY" , dailyData);
        startActivity(detailIntent);
    }
}


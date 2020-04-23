package android.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.weather.Models.DateTypeAdapter;
import android.example.weather.Models.Weather;
import android.example.weather.Models.WeatherData;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Getting recyclerview by ID from layout
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        //String[] data = {"7 degress" , "8 degrees" , "18 degrees" , "7 degress" , "8 degrees" , "18 degrees" , "7 degress" , "8 degrees" , "18 degrees" , "7 degress" , "8 degrees" , "18 degrees"};

        WeatherData data = new WeatherData();

        adapter = new Adapter(data);
        new FetchData().execute("");
        recyclerView.setAdapter(adapter);

    }



    public class FetchData extends AsyncTask<String , Void , WeatherData> {

        WeatherData data;

        public WeatherData getData() {
            return this.data;
        }

        @Override
        protected WeatherData doInBackground(String... params) {

            /* If there's no zip code, there's nothing to look up. */


            String location = params[0];
            String weatherRequestUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=60.99&lon=30.9&appid=410463b3935acea56c8171825dbb4440";

            URL url = null;
            try {
                url = new URL(weatherRequestUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String jsonWeatherResponse = NetworkUtils
                        .getResponseFromHttpUrl(url);
                System.out.println(jsonWeatherResponse);
                Gson gson = new GsonBuilder().registerTypeAdapter(Date.class , new DateTypeAdapter()).create();
                WeatherData data = gson.fromJson(jsonWeatherResponse , WeatherData.class);
                return data;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(WeatherData weatherData) {
            System.out.println(weatherData);
            adapter.Clear();
            adapter.AddData(weatherData);
            adapter.notifyDataSetChanged();
        }
    }

}

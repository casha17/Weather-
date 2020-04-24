package android.example.weather.Data;


import android.example.weather.ICallbackListener;
import android.example.weather.Models.DateTypeAdapter;
import android.example.weather.Models.WeatherData;
import android.example.weather.NetworkUtils;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class FetchData extends AsyncTask<String , Void , WeatherData> {

    WeatherData data;
    ICallbackListener callbackListener;

    public WeatherData getData() {
        return this.data;
    }

    public void setCallbackListener(ICallbackListener callbackListener) {
        this.callbackListener = callbackListener;
    }

    @Override
    protected WeatherData doInBackground(String... params) {

        /* If there's no zip code, there's nothing to look up. */

        String location = params[0];
        String weatherRequestUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=60.99&lon=30.9&units=metric&appid=410463b3935acea56c8171825dbb4440";

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
        this.callbackListener.callback(weatherData);
    }


}

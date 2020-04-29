package android.bachelor.weather.Data;


import android.bachelor.weather.ICallbackListener;
import android.bachelor.weather.Models.DateTypeAdapter;
import android.bachelor.weather.Models.GoogleModels.ImageSearch;
import android.bachelor.weather.Models.GoogleModels.Item;
import android.bachelor.weather.Models.GoogleModels.SearchInformation;
import android.bachelor.weather.Models.WeatherData;
import android.bachelor.weather.NetworkUtils;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class FetchData extends AsyncTask<String , Void , WeatherData> {

    private double _longitude;
    private double _latitude;

    public FetchData(double longitude, double latitude) {
        _longitude = longitude;
        _latitude = latitude;
    }

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
        String weatherRequestUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=" + this._latitude + "&lon="+this._longitude+"&units=metric&appid=410463b3935acea56c8171825dbb4440";

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

            String[] stringSplit = data.getTimezone().split("/");
            String placeName = stringSplit[1].replace("_", " ");

            // Positional image query
            String imageQuery = "https://www.googleapis.com/customsearch/v1?key=AIzaSyAzxkChBc2XJCady5tuKYj2jQhaxeOhaBY&cx=007790874964585735542:gmugdrnk524&q="+placeName+"+view&searchType=image";
            String imageQueryResult = NetworkUtils.getResponseFromHttpUrl(new URL(imageQuery));
            ImageSearch googleResult = gson.fromJson(imageQueryResult, ImageSearch.class);

            Item bestMatch = null;
            if(googleResult != null) {
                if(googleResult.getItems() != null) {
                    for(int i = 0; i < googleResult.getItems().length; i++) {
                        bestMatch = googleResult.getItems()[i];
                        break;
                    }
                }
            }

            data.setPlaceImage(bestMatch);
            data.setPlaceName(placeName);

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

package android.example.weather;

import android.example.weather.Models.WeatherData;

public interface ICallbackListener {
    void callback(WeatherData weatherData);
}

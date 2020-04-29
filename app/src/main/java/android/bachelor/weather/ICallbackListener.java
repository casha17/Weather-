package android.bachelor.weather;

import android.bachelor.weather.Models.WeatherData;

public interface ICallbackListener {
    void callback(WeatherData weatherData);
}

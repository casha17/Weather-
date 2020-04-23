package android.example.weather.Models;

import java.util.ArrayList;
import java.util.Date;

public class Hourly {
    private Date dt;
    private float temp;
    private float feels_like;
    private float pressure;
    private float humidity;
    private float dew_point;
    private float clouds;
    private float wind_speed;
    private float wind_deg;
    ArrayList< Weather > weather = new ArrayList < Weather > ();

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getDew_point() {
        return dew_point;
    }

    public void setDew_point(float dew_point) {
        this.dew_point = dew_point;
    }

    public float getClouds() {
        return clouds;
    }

    public void setClouds(float clouds) {
        this.clouds = clouds;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(float wind_deg) {
        this.wind_deg = wind_deg;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }
}

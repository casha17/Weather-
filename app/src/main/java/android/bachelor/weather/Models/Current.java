package android.bachelor.weather.Models;


import java.util.ArrayList;
import java.util.Date;

public class Current {
    private Date dt;
    private Date sunrise;
    private Date sunset;
    private float temp;
    private float feels_like;
    private float pressure;
    private float humidity;
    private float dew_point;
    private float uvi;
    private float clouds;
    private float wind_speed;
    private float wind_deg;
    ArrayList< Weather > weather = new ArrayList < Weather > ();


    // Getter Methods

    public Date getDt() {
        return dt;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public float getTemp() {
        return temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getDew_point() {
        return dew_point;
    }

    public float getUvi() {
        return uvi;
    }

    public float getClouds() {
        return clouds;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public float getWind_deg() {
        return wind_deg;
    }

    // Setter Methods

    public void setDt(Date date) {
        this.dt = date;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setDew_point(float dew_point) {
        this.dew_point = dew_point;
    }

    public void setUvi(float uvi) {
        this.uvi = uvi;
    }

    public void setClouds(float clouds) {
        this.clouds = clouds;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setWind_deg(float wind_deg) {
        this.wind_deg = wind_deg;
    }
}
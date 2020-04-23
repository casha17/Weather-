package android.example.weather.Models;

import java.util.ArrayList;

public class WeatherData {
    private float lat;
    private float lon;
    private String timezone;
    Current current;
    ArrayList< Hourly > hourly = new ArrayList < Hourly > ();
    ArrayList < Daily > daily = new ArrayList < Daily > ();
    // Getter Methods

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public ArrayList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<Hourly> hourly) {
        this.hourly = hourly;
    }

    public ArrayList<Daily> getDaily() {
        return daily;
    }

    public void setDaily(ArrayList<Daily> daily) {
        this.daily = daily;
    }
}

package android.bachelor.weather.Models;

import android.bachelor.weather.Models.GoogleModels.Item;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class WeatherData implements Serializable {

    private Item placeImage = null;
    private String placeName = "";

    private float lat;
    private float lon;
    private String timezone;
    Current current;
    ArrayList< Hourly > hourly = new ArrayList < Hourly > ();
    ArrayList < Daily > daily = new ArrayList < Daily > ();
    // Getter Methods

    public Item getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(Item placeImage) {
        this.placeImage = placeImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

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

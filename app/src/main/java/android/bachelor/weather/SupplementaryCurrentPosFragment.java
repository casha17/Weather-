package android.bachelor.weather;

import android.bachelor.weather.Models.GoogleModels.Image;
import android.bachelor.weather.Models.GoogleModels.Item;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Date;

public class SupplementaryCurrentPosFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_currentpos_supplementary, container, false);
    }

    public void setData(float _humidity, float _pressure, Date _sunrise, Date _sunset, float _uv, float _wind){
        final TextView humidity = (TextView)getView().findViewById(R.id.textViewHumidity);
        final TextView pressure = (TextView)getView().findViewById(R.id.textViewPressure);
        final TextView sunrise = (TextView)getView().findViewById(R.id.textViewSunrise);
        final TextView sunset = (TextView)getView().findViewById(R.id.textViewSunset);
        final TextView uv = (TextView)getView().findViewById(R.id.textViewUV);
        final TextView wind = (TextView)getView().findViewById(R.id.textViewWind);

        humidity.setText("Humidity\n" + _humidity);
        pressure.setText("Pressure\n" + _pressure);
        sunrise.setText("Sunrise\n" + _sunrise.getHours() + ": " + _sunrise.getMinutes());
        sunset.setText("Sunset\n" + _sunset.getHours() + ": " + _sunset.getMinutes());
        uv.setText("UV\n" + _uv);
        wind.setText("Winds\n" + _wind);
    }

}

package android.bachelor.weather;

import android.bachelor.weather.Models.Hourly;
import android.bachelor.weather.Models.WeatherData;
import android.content.Intent;
import android.bachelor.weather.Models.Daily;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private Daily daily;
    private WeatherData metadata;
    private CurrentPosFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Intent in  = getIntent();
        daily = (Daily) in.getSerializableExtra("DAILY");
        metadata = (WeatherData) in.getSerializableExtra("META");

        String day = new SimpleDateFormat("EEEE").format(daily.getDt());
        day = day.substring(0,1).toUpperCase() + day.substring(1);
        this.frag.setData(metadata.getPlaceImage(), day, (int)daily.getTemp().getDay()+"\u00B0/"+(int)daily.getTemp().getNight() , daily.getWeather().get(0).getDescription());

        ArrayList<Hourly> hourData = new ArrayList<>();
        // Check if there is any hourly data to display
        for(int i = 0; i < metadata.getHourly().size(); i++) {
            if(metadata.getHourly().get(i).getDt().after(daily.getDt()) || metadata.getHourly().get(i).getDt().compareTo(daily.getDt()) == 0) {
                hourData.add(metadata.getHourly().get(i));
            }
        }

        // if there is hourly data display it for the respective day.
        if(hourData.size() > 0) {
            ArrayList<Hourly> temp = new ArrayList<>();
            if(hourData.size() > 24) {
                for(int i = 0; i < 25; i++) {
                    temp.add(hourData.get(i));
                }
                hourData = temp;
            }
            // Show data
            // find recyler view and set data to display
            RecyclerView rView = findViewById(R.id.horizontaldetails);
            TextView err = findViewById(R.id.horizontalError);
            err.setVisibility(View.INVISIBLE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

            rView.setLayoutManager(linearLayoutManager);

            rView.setHasFixedSize(true);

            // Set empty data to avoid crash
            HorizontalAdapter adapter = new HorizontalAdapter(this, hourData);
            rView.setAdapter(adapter);
        } else {
            // Show error
            RecyclerView rView = findViewById(R.id.horizontaldetails);
            rView.setVisibility(View.INVISIBLE);
            TextView err = findViewById(R.id.horizontalError);
            err.setText("No hourly data for this date... Try an earlier day");
            err.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if(fragment instanceof CurrentPosFragment) {
            this.frag = (CurrentPosFragment)fragment;
        }
    }
}

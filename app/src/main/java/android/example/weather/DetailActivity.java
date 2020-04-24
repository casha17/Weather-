package android.example.weather;

import android.content.Intent;
import android.example.weather.Models.Daily;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView textView;
    private Daily daily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        textView = (TextView) findViewById(R.id.textView);



        Intent i  = getIntent();
        daily = (Daily) i.getParcelableExtra("DAILY");

        textView.setText(String.valueOf(daily.getHumidity()));
    }
}

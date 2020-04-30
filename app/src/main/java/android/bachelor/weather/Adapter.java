package android.bachelor.weather;

import android.content.Context;
import android.bachelor.weather.Models.Daily;
import android.bachelor.weather.Models.WeatherData;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private WeatherData mDataset;
    final private AdapterOnClickHandler ClickHandler;


    public interface AdapterOnClickHandler {
        void onClick(Daily dailyData, WeatherData meta);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView daynightTemp;
        public TextView day;
        public TextView description;
        public Daily DailyData;
        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            day = (TextView)view.findViewById(R.id.dayTextView);
            imageView = (ImageView)view.findViewById(R.id.weatherIcon);
            daynightTemp = (TextView)view.findViewById(R.id.daynighttemp);
            description = (TextView)view.findViewById(R.id.description);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            ClickHandler.onClick(DailyData, mDataset);
        }
    }


    public Adapter(WeatherData myDataset , AdapterOnClickHandler clickHandler ) {
        mDataset = myDataset;
        this.ClickHandler = clickHandler;
    }

    public void Clear() {
        this.mDataset = null;
    }

    public void AddData(WeatherData data) {
        this.mDataset = data;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.activity_textlayout;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem , parent , false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String day = new SimpleDateFormat("EEEE").format(this.mDataset.getDaily().get(position).getDt());
        day = day.substring(0,1).toUpperCase() + day.substring(1);
        if(position == 0) {
            day += " (Today)";
        }
        Daily daily = this.mDataset.getDaily().get(position);
        holder.day.setText(day);
        holder.daynightTemp.setText((int)daily.getTemp().getDay()+"\u00B0/"+(int)daily.getTemp().getNight()+"\u00B0");
        holder.description.setText(daily.getWeather().get(0).getDescription());
        holder.DailyData = this.mDataset.getDaily().get(position);
        String icon = this.mDataset.getDaily().get(position).getWeather().get(0).getIcon();
        String iconUrl = "https://openweathermap.org/img/w/" + icon + ".png";
        Picasso.get().load(iconUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataset.getDaily().size();
    }
}

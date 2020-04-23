package android.example.weather;

import android.content.Context;
import android.example.weather.Models.Weather;
import android.example.weather.Models.WeatherData;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private WeatherData mDataset;



    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewDayTemp;
        public TextView textViewNightTemp;

        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            textViewDayTemp = (TextView) view.findViewById(R.id.textViewDayTemp);
            imageView = (ImageView) view.findViewById(R.id.image);
            textViewNightTemp = (TextView) view.findViewById(R.id.textViewNightTemp);

        }

        void bind(int listIndex) {
            textViewDayTemp.setText(String.valueOf(listIndex));
        }
    }


    public Adapter(WeatherData myDataset) {
        mDataset = myDataset;
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
        holder.textViewDayTemp.setText(String.valueOf(this.mDataset.getDaily().get(position).getTemp().getDay()) + " C") ;
        holder.textViewNightTemp.setText(String.valueOf(this.mDataset.getDaily().get(position).getTemp().getNight()) + " C") ;
        holder.textViewNightTemp.setTextColor(Color.GRAY);
        String icon = this.mDataset.getDaily().get(position).getWeather().get(0).getIcon();
        String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
        Picasso.get().load(iconUrl).into(holder.imageView);




    }



    @Override
    public int getItemCount() {
        return mDataset.getDaily().size();
    }




}

package android.bachelor.weather;

import android.bachelor.weather.Models.Hourly;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    private ArrayList<Hourly> mData = new ArrayList<>();

    public HorizontalAdapter(Context context, ArrayList<Hourly> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Hourly data = mData.get(position);

        String hour = new SimpleDateFormat("HH").format(data.getDt());

        holder.boxDate.setText(hour);
        holder.boxTemp.setText((int)data.getTemp()+"\u00B0");
        String iconUrl = "https://openweathermap.org/img/w/" + data.getWeather().get(0).getIcon() + ".png";
        Picasso.get().load(iconUrl).into(holder.boxImage);
    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView boxDate;
        ImageView boxImage;
        TextView boxTemp;

        public ViewHolder(View itemView) {
            super(itemView);
            boxDate = itemView.findViewById(R.id.boxDate);
            boxImage = itemView.findViewById(R.id.boxImage);
            boxTemp = itemView.findViewById(R.id.boxTemp);
        }
    }
}

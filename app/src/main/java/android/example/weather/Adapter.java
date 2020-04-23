package android.example.weather;

import android.content.Context;
import android.example.weather.Models.Weather;
import android.example.weather.Models.WeatherData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private WeatherData mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public TextView informationText;

        public ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.textView);
            informationText = (TextView) view.findViewById(R.id.information_text);

        }

        void bind(int listIndex) {
            textView.setText(String.valueOf(listIndex));
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
        holder.textView.setText(String.valueOf(this.mDataset.getCurrent().getTemp()));
        holder.informationText.setText("The temperature for the current day is ");


    }



    @Override
    public int getItemCount() {
        return mDataset.getHourly().size();
    }




}

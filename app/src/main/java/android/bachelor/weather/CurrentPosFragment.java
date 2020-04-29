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

import org.w3c.dom.Text;

public class CurrentPosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.currentposfragmentlayout, container, false);
    }

    public void setData(Item placeImage, String placeName, double temp) {
        System.out.println();
        final FrameLayout frame = (FrameLayout)getView().findViewById(R.id.currentPosFrame);
        final TextView cityName = (TextView)getView().findViewById(R.id.frameCityName);
        final TextView citeTemp = (TextView)getView().findViewById(R.id.frameCityTemp);

        cityName.setText(placeName);
        citeTemp.setText(""+(int)temp+"\u00B0");

        final ImageView image = new ImageView(getContext());
        Picasso.get().load(placeImage.getLink()).into(image, new Callback() {
            @Override
            public void onSuccess() {
                Drawable drawable = image.getDrawable();
                frame.setForeground(drawable);
            }
            @Override
            public void onError(Exception e) {
                System.out.println("Failed to load image");
            }
        });
    }

    private void ImageViewLoadCallback() {

    }
}

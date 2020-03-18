package com.dataentropia.androidmvvm.databinding;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.dataentropia.androidmvvm.helpers.Constant;

public class LoadImages {
    @BindingAdapter({"loadImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(Constant.Api.BASE_IMAGE_URL + imageUrl).into(view);
    }
}

package com.dataentropia.androidmvvm.binding_adatpers;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.dataentropia.androidmvvm.util.Constant;
import androidx.databinding.BindingAdapter;

public class BindingAdatpers {
    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(Constant.Api.BASE_IMAGE_URL + imageUrl).into(view);
    }
}
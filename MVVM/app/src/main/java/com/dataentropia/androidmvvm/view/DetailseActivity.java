package com.dataentropia.androidmvvm.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;

import com.dataentropia.androidmvvm.databinding.ActivityDetailseBinding;
import com.dataentropia.androidmvvm.R;
import com.dataentropia.androidmvvm.model.Movie;


public class DetailseActivity extends AppCompatActivity {
    private ActivityDetailseBinding detailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_detailse);
        Intent intent = getIntent();
        if (intent != null) {
            Movie movie = intent.getParcelableExtra("Movie");
            detailsBinding.setMovie(movie);
        }
    }
}

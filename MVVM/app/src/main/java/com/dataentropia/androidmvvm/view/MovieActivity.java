package com.dataentropia.androidmvvm.view;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.dataentropia.androidmvvm.databinding.ActivityMainBinding;
import com.dataentropia.androidmvvm.R;
import com.dataentropia.androidmvvm.adapter.MovieAdapter;
import com.dataentropia.androidmvvm.app.MyApplication;
import com.dataentropia.androidmvvm.model.Movie;
import com.dataentropia.androidmvvm.viewmodel.MovieViewModel;


import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class MovieActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    @Inject
    Application application;
    private ActivityMainBinding binding;
    private MovieViewModel movieViewModel;
    public static ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((MyApplication) getApplication()).getComponent().inject(this);
        binding.setLifecycleOwner(this);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getMovies();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();
//        showLoadingBar();
        observableChanges();
    }

    private void observableChanges() {
        movieViewModel.movieList.observe(this, responseMovie -> Recycler(responseMovie.getMovies()));

        movieViewModel.errorMessage.observe(this, s -> Toast.makeText(MovieActivity.this, s, Toast.LENGTH_LONG).show());

    }



    private void Recycler(List<Movie> movies) {
        binding.setAdapter(new MovieAdapter(movies, MovieActivity.this));
    }
}
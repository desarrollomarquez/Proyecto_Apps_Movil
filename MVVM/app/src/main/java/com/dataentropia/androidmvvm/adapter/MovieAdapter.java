package com.dataentropia.androidmvvm.adapter;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dataentropia.androidmvvm.databinding.MatchCalenderItemBinding;
import com.dataentropia.androidmvvm.R;

import com.dataentropia.androidmvvm.servicios.entity.Movie;
import com.dataentropia.androidmvvm.view.DetailseActivity;


import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movieList ;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MatchCalenderItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.match_calender_item, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie = movieList.get(position);
        holder.binding.setMovie(movie);
        holder.bind(movie);
        holder.binding.setItemClick(f -> {
            Intent intent = new Intent(context, DetailseActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Movie", movie);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private MatchCalenderItemBinding binding;

        public MovieViewHolder(MatchCalenderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.executePendingBindings();
        }
    }
}
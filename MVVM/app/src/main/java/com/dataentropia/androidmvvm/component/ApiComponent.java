package com.dataentropia.androidmvvm.component;
import com.dataentropia.androidmvvm.repository.MovieRepository;
import com.dataentropia.androidmvvm.view.MovieActivity;
import com.dataentropia.androidmvvm.module.ApiClientModule;
import com.dataentropia.androidmvvm.module.AppModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ApiClientModule.class, AppModule.class})
public interface ApiComponent {
    void inject(MovieActivity movieActivity);
    void injectMovie(MovieRepository movieRepository);
}
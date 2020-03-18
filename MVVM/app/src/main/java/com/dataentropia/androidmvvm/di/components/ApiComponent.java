package com.dataentropia.androidmvvm.di.components;
import com.dataentropia.androidmvvm.remote.repository.MovieRepository;
import com.dataentropia.androidmvvm.remote.repository.TipoDocumentoRepository;
import com.dataentropia.androidmvvm.view.LoginActivity;
import com.dataentropia.androidmvvm.view.MovieActivity;
import com.dataentropia.androidmvvm.di.modules.ApiClientModule;
import com.dataentropia.androidmvvm.di.modules.AppModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ApiClientModule.class, AppModule.class})
public interface ApiComponent {
    void inject(MovieActivity movieActivity);
    void injectLogin(LoginActivity loginActivity);
    void injectMovie(MovieRepository movieRepository);
    void injectTipoDocumento(TipoDocumentoRepository  tipoDocumentoRepository);
}
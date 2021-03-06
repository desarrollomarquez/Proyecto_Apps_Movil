package com.nytimes.articles.di.components;

import android.app.Application;

import com.nytimes.articles.NYTimesApp;
import com.nytimes.articles.di.builder.ActivityBuilderModule;
import com.nytimes.articles.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


/**
 * The main application component which initializes all the dependent modules
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})

public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(NYTimesApp nyTimesApp);
}
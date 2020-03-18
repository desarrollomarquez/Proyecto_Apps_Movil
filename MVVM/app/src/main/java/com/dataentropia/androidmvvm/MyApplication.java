package com.dataentropia.androidmvvm;
import android.app.Application;
import com.dataentropia.androidmvvm.di.components.ApiComponent;

import com.dataentropia.androidmvvm.di.components.DaggerApiComponent;
import com.dataentropia.androidmvvm.di.modules.ApiClientModule;
import com.dataentropia.androidmvvm.di.modules.AppModule;
import com.dataentropia.androidmvvm.helpers.Constant;

public class MyApplication extends Application {

    public static ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiClientModule(new ApiClientModule(Constant.Api.BASE_URL))
                .build();
    }

    public static ApiComponent getComponent() {
        return mApiComponent;
    }
}
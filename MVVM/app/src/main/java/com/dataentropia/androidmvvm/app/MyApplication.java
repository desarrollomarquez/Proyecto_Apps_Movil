package com.dataentropia.androidmvvm.app;
import android.app.Application;
import com.dataentropia.androidmvvm.component.ApiComponent;

import com.dataentropia.androidmvvm.component.DaggerApiComponent;
import com.dataentropia.androidmvvm.module.ApiClientModule;
import com.dataentropia.androidmvvm.module.AppModule;
import com.dataentropia.androidmvvm.util.Constant;

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
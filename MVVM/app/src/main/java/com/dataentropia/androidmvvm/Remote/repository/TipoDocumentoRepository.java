package com.dataentropia.androidmvvm.remote.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.dataentropia.androidmvvm.MyApplication;
import com.dataentropia.androidmvvm.remote.ApiInterface;
import com.dataentropia.androidmvvm.servicios.dto.ValidarUsuarioCreadoResponse;

import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.dataentropia.androidmvvm.view.MovieActivity.progressDialog;


public class TipoDocumentoRepository {
    @Inject
    Retrofit retrofit;
    @Inject
    Application application;
    private static TipoDocumentoRepository repository;
    private ApiInterface apiInterface ;

    public static TipoDocumentoRepository getInstance(){
        if (repository == null){
            repository = new TipoDocumentoRepository();
        }
        return repository;
    }

    public TipoDocumentoRepository(){
        MyApplication.getComponent().injectTipoDocumento(this);
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public MutableLiveData<ValidarUsuarioCreadoResponse> getTids(Map<String , String> stringMap){
        MutableLiveData<ValidarUsuarioCreadoResponse> responseTidMutableLiveData = new MutableLiveData<>();
        apiInterface.getTids(stringMap).enqueue(new Callback<ValidarUsuarioCreadoResponse>() {
            @Override
            public void onResponse(Call<ValidarUsuarioCreadoResponse> call, Response<ValidarUsuarioCreadoResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                    responseTidMutableLiveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<ValidarUsuarioCreadoResponse> call, Throwable t) {
                progressDialog.dismiss();
                responseTidMutableLiveData.setValue(null);
            }
        });
        return responseTidMutableLiveData;
    }
}
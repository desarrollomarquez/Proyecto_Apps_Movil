package com.dataentropia.androidmvvm.remote;
import com.dataentropia.androidmvvm.servicios.dto.ResponseMovie;
import com.dataentropia.androidmvvm.servicios.dto.ValidarUsuarioCreadoResponse;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("movie/popular")
    Call<ResponseMovie> getMovies(@QueryMap Map<String , String> queryParameters);

    @GET("movie/popular")
    Call<ValidarUsuarioCreadoResponse> getTids(@QueryMap Map<String , String> queryParameters);
}

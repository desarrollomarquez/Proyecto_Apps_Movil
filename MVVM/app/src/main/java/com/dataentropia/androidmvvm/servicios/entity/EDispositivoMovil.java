package com.dataentropia.androidmvvm.servicios.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EDispositivoMovil implements Parcelable {

    @SerializedName("versionApp")
    @Expose
    private String versionApp;
    @SerializedName("imeis")
    @Expose
    private List<EImei> imeis;
    @SerializedName("simCards")
    @Expose
    private List<ESimCard> simCards;

    protected EDispositivoMovil(Parcel in) {
        versionApp = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(versionApp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EDispositivoMovil> CREATOR = new Creator<EDispositivoMovil>() {
        @Override
        public EDispositivoMovil createFromParcel(Parcel in) {
            return new EDispositivoMovil(in);
        }

        @Override
        public EDispositivoMovil[] newArray(int size) {
            return new EDispositivoMovil[size];
        }
    };



    public String getVersionApp() {
        return versionApp;
    }
    public void setVersionApp(String versionApp) {
        this.versionApp = versionApp;
    }
    public List<EImei> getImeis() {
        return imeis;
    }
    public void setImeis(List<EImei> imeis) {
        this.imeis = imeis;
    }
    public List<ESimCard> getSimCards() {
        return simCards;
    }
    public void setSimCards(List<ESimCard> simCards) {
        this.simCards = simCards;
    }


}

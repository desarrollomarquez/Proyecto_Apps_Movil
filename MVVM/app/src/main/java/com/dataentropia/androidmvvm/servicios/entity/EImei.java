package com.dataentropia.androidmvvm.servicios.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EImei implements Parcelable {

    @SerializedName("imeiDispositivo")
    @Expose
    public String imeiDispositivo;

    public EImei(String imeiDispositivo) {
        this.imeiDispositivo = imeiDispositivo;
    }

    protected EImei(Parcel in) {
        imeiDispositivo = in.readString();
    }

    public static final Creator<EImei> CREATOR = new Creator<EImei>() {
        @Override
        public EImei createFromParcel(Parcel in) {
            return new EImei(in);
        }

        @Override
        public EImei[] newArray(int size) {
            return new EImei[size];
        }
    };

    public String getImeiDispositivo() {
        return imeiDispositivo;
    }

    public void setImeiDispositivo(String imeiDispositivo) {
        this.imeiDispositivo = imeiDispositivo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imeiDispositivo);
    }
}

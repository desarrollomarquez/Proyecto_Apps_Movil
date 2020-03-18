package com.dataentropia.androidmvvm.servicios.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ESimCard implements Parcelable {

    @SerializedName("numeroMovil")
    @Expose
    public String numeroMovil;

    protected ESimCard(Parcel in) {
        numeroMovil = in.readString();
    }

    public static final Creator<ESimCard> CREATOR = new Creator<ESimCard>() {
        @Override
        public ESimCard createFromParcel(Parcel in) {
            return new ESimCard(in);
        }

        @Override
        public ESimCard[] newArray(int size) {
            return new ESimCard[size];
        }
    };

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public ESimCard(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numeroMovil);
    }
}

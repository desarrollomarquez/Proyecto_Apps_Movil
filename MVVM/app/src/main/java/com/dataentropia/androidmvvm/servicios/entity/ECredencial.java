package com.dataentropia.androidmvvm.servicios.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ECredencial implements Parcelable {

    @SerializedName("clave")
    @Expose
    public String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }



    protected ECredencial(Parcel in) {
        clave = in.readString();
    }

    public static final Creator<ECredencial> CREATOR = new Creator<ECredencial>() {
        @Override
        public ECredencial createFromParcel(Parcel in) {
            return new ECredencial(in);
        }

        @Override
        public ECredencial[] newArray(int size) {
            return new ECredencial[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(clave);
    }
}

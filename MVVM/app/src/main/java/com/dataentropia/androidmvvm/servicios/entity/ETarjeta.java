package com.dataentropia.androidmvvm.servicios.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETarjeta implements Parcelable {

    @SerializedName("numeroTarjeta")
    @Expose
    public String numeroTarjeta;
    @SerializedName("perfilTarjeta")
    @Expose
    public String perfilTarjeta;
    @SerializedName("estadoTarjeta")
    @Expose
    public String estadoTarjeta;
    @SerializedName("tipoTarjeta")
    @Expose
    public String tipoTarjeta;

    public ETarjeta(String numeroTarjeta, String perfilTarjeta, String estadoTarjeta, String tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.perfilTarjeta = perfilTarjeta;
        this.estadoTarjeta = estadoTarjeta;
        this.tipoTarjeta = tipoTarjeta;
    }

    protected ETarjeta(Parcel in) {
        numeroTarjeta = in.readString();
        perfilTarjeta = in.readString();
        estadoTarjeta = in.readString();
        tipoTarjeta = in.readString();
    }

    public static final Creator<ETarjeta> CREATOR = new Creator<ETarjeta>() {
        @Override
        public ETarjeta createFromParcel(Parcel in) {
            return new ETarjeta(in);
        }

        @Override
        public ETarjeta[] newArray(int size) {
            return new ETarjeta[size];
        }
    };

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getPerfilTarjeta() {
        return perfilTarjeta;
    }

    public void setPerfilTarjeta(String perfilTarjeta) {
        this.perfilTarjeta = perfilTarjeta;
    }

    public String getEstadoTarjeta() {
        return estadoTarjeta;
    }

    public void setEstadoTarjeta(String estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numeroTarjeta);
        dest.writeString(perfilTarjeta);
        dest.writeString(estadoTarjeta);
        dest.writeString(tipoTarjeta);
    }
}

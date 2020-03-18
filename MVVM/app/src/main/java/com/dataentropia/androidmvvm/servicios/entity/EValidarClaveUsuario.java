package com.dataentropia.androidmvvm.servicios.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.dataentropia.androidmvvm.servicios.constants.Constantes.EstadoConsultaUsuario;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EValidarClaveUsuario implements Parcelable {

    @SerializedName("pValida")
    @Expose
    public EstadoConsultaUsuario pValida;
    @SerializedName("pesId")
    @Expose
    public String pesId;
    @SerializedName("uctId")
    @Expose
    public long uctId;
    @SerializedName("uctIntentos")
    @Expose
    public int uctIntentos;
    @SerializedName("uctFechaBloqueo")
    @Expose
    public String uctFechaBloqueo;

    public EValidarClaveUsuario(EstadoConsultaUsuario pValida, String pesId, long uctId, int uctIntentos, String uctFechaBloqueo) {
        this.pValida = pValida;
        this.pesId = pesId;
        this.uctId = uctId;
        this.uctIntentos = uctIntentos;
        this.uctFechaBloqueo = uctFechaBloqueo;
    }

    protected EValidarClaveUsuario(Parcel in) {
        pesId = in.readString();
        uctId = in.readLong();
        uctIntentos = in.readInt();
        uctFechaBloqueo = in.readString();
    }

    public static final Creator<EValidarClaveUsuario> CREATOR = new Creator<EValidarClaveUsuario>() {
        @Override
        public EValidarClaveUsuario createFromParcel(Parcel in) {
            return new EValidarClaveUsuario(in);
        }

        @Override
        public EValidarClaveUsuario[] newArray(int size) {
            return new EValidarClaveUsuario[size];
        }
    };

    public EstadoConsultaUsuario getPValida () {
        return pValida;
    }
    public void setPValida(EstadoConsultaUsuario pValida) {
        this.pValida = pValida;
    }

    public void setPesId(String pesId) {
        this.pesId = pesId;
    }
    public String getPesId () {
        return pesId;
    }

    public void setUctId(long uctId) {
        this.uctId = uctId;
    }
    public long getUctId () {
        return uctId;
    }

    public void setUctIntentos(int uctIntentos) {
        this.uctIntentos = uctIntentos;
    }
    public int getUctIntentos () {
        return uctIntentos;
    }

    public void setUctFechaBloqueo(String uctFechaBloqueo) {
        this.uctFechaBloqueo = uctFechaBloqueo;
    }
    public String getUctFechaBloqueo () {
        return uctFechaBloqueo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pesId);
        dest.writeLong(uctId);
        dest.writeInt(uctIntentos);
        dest.writeString(uctFechaBloqueo);
    }
}

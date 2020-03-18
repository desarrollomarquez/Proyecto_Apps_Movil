package com.dataentropia.androidmvvm.servicios.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EDocumentoIdentificacion implements Parcelable {

    @SerializedName("tipoDocumento")
    @Expose
    public int tipoDocumento;
    @SerializedName("numeroDocumento")
    @Expose
    public String numeroDocumento;
    @SerializedName("fechaExpDocumento")
    @Expose
    public String fechaExpDocumento;
    @SerializedName("lugarExpDocumento")
    @Expose
    public String lugarExpDocumento;

    public EDocumentoIdentificacion(int tipoDocumento, String numeroDocumento, String fechaExpDocumento, String lugarExpDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaExpDocumento = fechaExpDocumento;
        this.lugarExpDocumento = lugarExpDocumento;
    }

    public EDocumentoIdentificacion(){
    }

    protected EDocumentoIdentificacion(Parcel in) {
        tipoDocumento = in.readInt();
        numeroDocumento = in.readString();
        fechaExpDocumento = in.readString();
        lugarExpDocumento = in.readString();
    }

    public static final Creator<EDocumentoIdentificacion> CREATOR = new Creator<EDocumentoIdentificacion>() {
        @Override
        public EDocumentoIdentificacion createFromParcel(Parcel in) {
            return new EDocumentoIdentificacion(in);
        }

        @Override
        public EDocumentoIdentificacion[] newArray(int size) {
            return new EDocumentoIdentificacion[size];
        }
    };

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getFechaExpDocumento() {
        return fechaExpDocumento;
    }

    public void setFechaExpDocumento(String fechaExpDocumento) {
        this.fechaExpDocumento = fechaExpDocumento;
    }
    public String getLugarExpDocumento() {
        return lugarExpDocumento;
    }

    public void setLugarExpDocumento(String lugarExpDocumento) {
        this.lugarExpDocumento = lugarExpDocumento;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tipoDocumento);
        dest.writeString(numeroDocumento);
        dest.writeString(fechaExpDocumento);
        dest.writeString(lugarExpDocumento);
    }
}

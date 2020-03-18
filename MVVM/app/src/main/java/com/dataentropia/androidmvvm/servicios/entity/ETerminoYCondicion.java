package com.dataentropia.androidmvvm.servicios.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETerminoYCondicion implements Parcelable {

    @SerializedName("idTerminoYCondicion")
    @Expose
    private int idTerminoYCondicion;
    @SerializedName("usuarioAceptoTermyCond")
    @Expose
    private boolean usuarioAceptoTermyCond;
    @SerializedName("tituloTerminoYCondicion")
    @Expose
    private String tituloTerminoYCondicion;
    @SerializedName("contenidoTerminoYCondicion")
    @Expose
    private String contenidoTerminoYCondicion;
    @SerializedName("seRequiereParaContinuar")
    @Expose
    private boolean seRequiereParaContinuar;
    @SerializedName("ordenPresentacion")
    @Expose
    private int ordenPresentacion;

    public ETerminoYCondicion(int idTerminoYCondicion, boolean usuarioAceptoTermyCond, String tituloTerminoYCondicion, String contenidoTerminoYCondicion, boolean seRequiereParaContinuar, int ordenPresentacion) {
        this.idTerminoYCondicion = idTerminoYCondicion;
        this.usuarioAceptoTermyCond = usuarioAceptoTermyCond;
        this.tituloTerminoYCondicion = tituloTerminoYCondicion;
        this.contenidoTerminoYCondicion = contenidoTerminoYCondicion;
        this.seRequiereParaContinuar = seRequiereParaContinuar;
        this.ordenPresentacion = ordenPresentacion;
    }

    protected ETerminoYCondicion(Parcel in) {
        idTerminoYCondicion = in.readInt();
        usuarioAceptoTermyCond = in.readByte() != 0;
        tituloTerminoYCondicion = in.readString();
        contenidoTerminoYCondicion = in.readString();
        seRequiereParaContinuar = in.readByte() != 0;
        ordenPresentacion = in.readInt();
    }

    public static final Creator<ETerminoYCondicion> CREATOR = new Creator<ETerminoYCondicion>() {
        @Override
        public ETerminoYCondicion createFromParcel(Parcel in) {
            return new ETerminoYCondicion(in);
        }

        @Override
        public ETerminoYCondicion[] newArray(int size) {
            return new ETerminoYCondicion[size];
        }
    };

    public int getOrdenPresentacion() {
        return ordenPresentacion;
    }
    public void setOrdenPresentacion(int ordenPresentacion) {
        this.ordenPresentacion = ordenPresentacion;
    }
    public int getIdTerminoYCondicion() {
        return idTerminoYCondicion;
    }
    public void setIdTerminoYCondicion(int idTerminoYCondicion) {
        this.idTerminoYCondicion = idTerminoYCondicion;
    }
    public boolean isEstadoAceptacion() {
        return usuarioAceptoTermyCond;
    }
    public void setEstadoAceptacion(boolean estadoAceptacion) {
        this.usuarioAceptoTermyCond = estadoAceptacion;
    }
    public String getTituloTerminoYCondicion() {
        return tituloTerminoYCondicion;
    }
    public void setTituloTerminoYCondicion(String tituloTerminoYCondicion) {
        this.tituloTerminoYCondicion = tituloTerminoYCondicion;
    }
    public String getContenidoTerminoYCondicion() {
        return contenidoTerminoYCondicion;
    }
    public void setContenidoTerminoYCondicion(String contenidoTerminoYCondicion) {
        this.contenidoTerminoYCondicion = contenidoTerminoYCondicion;
    }
    public boolean getSeRequiereParaContinuar() {
        return seRequiereParaContinuar;
    }
    public void setSeRequiereParaContinuar(boolean seRequiereParaContinuar) {
        this.seRequiereParaContinuar = seRequiereParaContinuar;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idTerminoYCondicion);
        dest.writeByte((byte) (usuarioAceptoTermyCond ? 1 : 0));
        dest.writeString(tituloTerminoYCondicion);
        dest.writeString(contenidoTerminoYCondicion);
        dest.writeByte((byte) (seRequiereParaContinuar ? 1 : 0));
        dest.writeInt(ordenPresentacion);
    }
}




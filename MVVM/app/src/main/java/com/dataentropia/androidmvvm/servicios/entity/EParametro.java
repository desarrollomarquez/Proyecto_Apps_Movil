package com.dataentropia.androidmvvm.servicios.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EParametro implements Parcelable {

    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("valor")
    @Expose
    private String valor;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    protected EParametro(Parcel in) {
        codigo = in.readString();
        valor = in.readString();
        estado = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<EParametro> CREATOR = new Creator<EParametro>() {
        @Override
        public EParametro createFromParcel(Parcel in) {
            return new EParametro(in);
        }

        @Override
        public EParametro[] newArray(int size) {
            return new EParametro[size];
        }
    };

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EParametro(String codigo, String valor, String estado, String descripcion) {
        this.codigo = codigo;
        this.valor = valor;
        this.estado = estado;
        this.descripcion = descripcion;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(valor);
        dest.writeString(estado);
        dest.writeString(descripcion);
    }
}
